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

package org.netbeans.jellytools.nodes;

import javax.swing.tree.TreePath;
import org.netbeans.jellytools.nodes.Node;
import org.netbeans.jellytools.actions.*;
import org.netbeans.jemmy.operators.JTreeOperator;

/** Node representing HTML file */
public class HTMLNode extends Node {

    /** creates new HTMLNode
     * @param treeOperator JTreeOperator tree
     * @param treePath String tree path */
    public HTMLNode(JTreeOperator treeOperator, String treePath) {
       super(treeOperator, treePath);
    }

    /** creates new HTMLNode
     * @param parent parent Node
     * @param treeSubPath String tree path from parent node */    
    public HTMLNode(Node parent, String treeSubPath) {
       super(parent, treeSubPath);
    }

    /** creates new HTMLNode
     * @param treeOperator JTreeOperator tree
     * @param path TreePath */    
    public HTMLNode(JTreeOperator treeOperator, TreePath path) {
       super(treeOperator, path);
    }

    static final ViewAction viewAction = new ViewAction();
    static final OpenAction openAction = new OpenAction();
    static final CutAction cutAction = new CutAction();
    static final CopyAction copyAction = new CopyAction();
    static final PasteAction pasteAction = new PasteAction();
    static final DeleteAction deleteAction = new DeleteAction();
    static final SaveAsTemplateAction saveAsTemplateAction = new SaveAsTemplateAction();
    static final PropertiesAction propertiesAction = new PropertiesAction();
   
    /** tests popup menu items for presence */    
    public void verifyPopup() {
        verifyPopup(new Action[]{
            viewAction,
            openAction,
            cutAction,
            copyAction,
            pasteAction,
            deleteAction,
            saveAsTemplateAction,
            propertiesAction
        });
    }
    
    /** performs ViewAction with this node */    
    public void view() {
        viewAction.perform(this);
    }

    /** performs OpenAction with this node */    
    public void open() {
        openAction.perform(this);
    }

    /** performs CutAction with this node */    
    public void cut() {
        cutAction.perform(this);
    }

    /** performs CopyAction with this node */    
    public void copy() {
        copyAction.perform(this);
    }

    /** performs PasteAction with this node */    
    public void paste() {
        pasteAction.perform(this);
    }

    /** performs DeleteAction with this node */    
    public void delete() {
        deleteAction.perform(this);
    }

    /** performs RenameAction with this node */    
    public void rename() {
        new ActionNoBlock(null, "Refactor|Rename...").perform(this);
    }

    /** performs SaveAsTemplateAction with this node */    
    public void saveAsTemplate() {
        saveAsTemplateAction.perform(this);
    }

    /** performs PropertiesAction with this node */    
    public void properties() {
        propertiesAction.perform(this);
    }
   
}
