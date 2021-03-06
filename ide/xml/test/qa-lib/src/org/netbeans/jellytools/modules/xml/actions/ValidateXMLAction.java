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
package org.netbeans.jellytools.modules.xml.actions;

import java.awt.event.KeyEvent;
import org.netbeans.jellytools.Bundle;
import org.netbeans.jellytools.actions.ActionNoBlock;

/** ValidateXMLAction class
 * @author <a href="mailto:mschovanek@netbeans.org">Martin Schovanek</a> */
public class ValidateXMLAction extends ActionNoBlock {

    private static final String popup =
    Bundle.getStringTrimmed("org.netbeans.modules.xml.tools.actions.Bundle", "NAME_Validate_XML");
    private static final Shortcut shortcut =
    new Shortcut(KeyEvent.VK_F9, KeyEvent.ALT_MASK | KeyEvent.SHIFT_MASK);

    /** creates new ValidateXMLAction instance */    
    public ValidateXMLAction() {
        super(null, popup, "org.netbeans.modules.xml.tools.actions.ValidateAction", shortcut);
    }
}
