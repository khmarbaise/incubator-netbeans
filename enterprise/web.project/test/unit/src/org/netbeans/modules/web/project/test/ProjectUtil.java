/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.web.project.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.netbeans.junit.NbTestCase;

/**
 *
 * @author Petr Hejl
 */
public final class ProjectUtil {

    private ProjectUtil() {
        super();
    }
    
    public static File getProjectAsFile(NbTestCase test, String projectFolderName) throws IOException {
        File f = new File(new File(test.getDataDir(), "projects"), projectFolderName);
        if (!f.exists()) {
            // maybe it's zipped
            File archive = new File(new File(test.getDataDir(), "projects"), projectFolderName + ".zip");
            if (archive.exists() && archive.isFile()) {
                unZip(archive, test.getWorkDir());
                f = new File(test.getWorkDir(), projectFolderName);
            }
        }
        NbTestCase.assertTrue("project directory has to exists: " + f, f.exists());
        return f;
    }

    private static void unZip(File archive, File destination) throws IOException {
        if (!archive.exists()) {
            throw new FileNotFoundException(archive + " does not exist.");
        }
        ZipFile zipFile = new ZipFile(archive);
        Enumeration<? extends ZipEntry> all = zipFile.entries();
        while (all.hasMoreElements()) {
            extractFile(zipFile, all.nextElement(), destination);
        }
    }

    private static void extractFile(ZipFile zipFile, ZipEntry e, File destination) throws IOException {
        String zipName = e.getName();
        if (zipName.startsWith("/")) {
            zipName = zipName.substring(1);
        }
        if (zipName.endsWith("/")) {
            return;
        }
        int ix = zipName.lastIndexOf('/');
        if (ix > 0) {
            String dirName = zipName.substring(0, ix);
            File d = new File(destination, dirName);
            if (!(d.exists() && d.isDirectory())) {
                if (!d.mkdirs()) {
                    NbTestCase.fail("Warning: unable to mkdir " + dirName);
                }
            }
        }
        FileOutputStream os = new FileOutputStream(destination.getAbsolutePath() + "/" + zipName);
        InputStream is = zipFile.getInputStream(e);
        int n = 0;
        byte[] buff = new byte[8192];
        while ((n = is.read(buff)) > 0) {
            os.write(buff, 0, n);
        }
        is.close();
        os.close();
    }    
}
