/*
 * Autopsy Forensic Browser
 * 
 * Copyright 2013 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.directorytree;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.openide.util.ImageUtilities;
import org.sleuthkit.autopsy.datamodel.Tags;

public class CreateTagDialog extends JDialog {
    private static final String TAG_ICON_PATH = "org/sleuthkit/autopsy/images/tag-folder-blue-icon-16.png";
    private static String newTagName;

    /**
     * Creates new form CreateTagDialog
     */
    private CreateTagDialog(JFrame parent) {
        super(parent, true);
        init();
    }
    
    public static String getNewTagNameDialog(JFrame parent) {
        new CreateTagDialog(parent);
        return newTagName;
    }
    
    private void init() {
        
        setTitle("Create a new tag");
        
        initComponents();
        
        tagsTable.setModel(new TagsTableModel());
        tagsTable.setTableHeader(null);

        //completely disable selections
        tagsTable.setCellSelectionEnabled(false);
        tagsTable.setFocusable(false);
        tagsTable.setRowHeight(tagsTable.getRowHeight() + 5);
        
        setIconImage(ImageUtilities.loadImage(TAG_ICON_PATH));
        
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        // set the popUp window / JFrame
        int w = this.getSize().width;
        int h = this.getSize().height;

        // set the location of the popUp Window on the center of the screen
        setLocation((screenDimension.width - w) / 2, (screenDimension.height - h) / 2);
        setVisible(true); //blocks
    }
    
    private boolean containsIllegalCharacters(String content) {
        if ((content.contains("\\") || content.contains(":") || content.contains("*")
                || content.contains("?") || content.contains("\"") || content.contains("<")
                || content.contains(">") || content.contains("|"))) {
            return true;
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tagsTable = new javax.swing.JTable();
        preexistingLabel = new javax.swing.JLabel();
        newTagPanel = new javax.swing.JPanel();
        tagNameLabel = new javax.swing.JLabel();
        tagNameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(CreateTagDialog.class, "CreateTagDialog.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(okButton, org.openide.util.NbBundle.getMessage(CreateTagDialog.class, "CreateTagDialog.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tagsTable.setBackground(new java.awt.Color(240, 240, 240));
        tagsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tagsTable.setShowHorizontalLines(false);
        tagsTable.setShowVerticalLines(false);
        tagsTable.setTableHeader(null);
        jScrollPane1.setViewportView(tagsTable);

        org.openide.awt.Mnemonics.setLocalizedText(preexistingLabel, org.openide.util.NbBundle.getMessage(CreateTagDialog.class, "CreateTagDialog.preexistingLabel.text")); // NOI18N

        newTagPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(CreateTagDialog.class, "CreateTagDialog.newTagPanel.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(tagNameLabel, org.openide.util.NbBundle.getMessage(CreateTagDialog.class, "CreateTagDialog.tagNameLabel.text")); // NOI18N

        tagNameField.setText(org.openide.util.NbBundle.getMessage(CreateTagDialog.class, "CreateTagDialog.tagNameField.text")); // NOI18N
        tagNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tagNameFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout newTagPanelLayout = new javax.swing.GroupLayout(newTagPanel);
        newTagPanel.setLayout(newTagPanelLayout);
        newTagPanelLayout.setHorizontalGroup(
            newTagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newTagPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tagNameLabel)
                .addGap(36, 36, 36)
                .addComponent(tagNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );
        newTagPanelLayout.setVerticalGroup(
            newTagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newTagPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newTagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tagNameLabel)
                    .addComponent(tagNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preexistingLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 233, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton))
                    .addComponent(newTagPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(preexistingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(newTagPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        newTagName = null;
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String tagName = tagNameField.getText();
        if (tagName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Must supply a tag name to continue.", "Tag Name", JOptionPane.ERROR_MESSAGE);
        } else if (containsIllegalCharacters(tagName)) {
            JOptionPane.showMessageDialog(null, "The tag name contains illegal characters.\nCannot contain any of the following symbols: \\ : * ? \" < > |",
                    "Illegal Characters", JOptionPane.ERROR_MESSAGE);
        } else {
            newTagName = tagName;
            dispose();
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            okButtonActionPerformed(null);
        }
    }//GEN-LAST:event_formKeyReleased

    private void tagNameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tagNameFieldKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            okButtonActionPerformed(null);
        }
    }//GEN-LAST:event_tagNameFieldKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel newTagPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel preexistingLabel;
    private javax.swing.JTextField tagNameField;
    private javax.swing.JLabel tagNameLabel;
    private javax.swing.JTable tagsTable;
    // End of variables declaration//GEN-END:variables

    private class TagsTableModel extends AbstractTableModel {
        List<String> tagNames;
        
        TagsTableModel() {
            tagNames = Tags.getTagNames();
        }

        @Override
        public int getRowCount() {
            return tagNames.size();
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public String getValueAt(int rowIndex, int columnIndex) {
            return tagNames.get(rowIndex);
        }
    }
}

