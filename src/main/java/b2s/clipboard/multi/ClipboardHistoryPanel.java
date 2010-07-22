/**
 * Copyright to the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package b2s.clipboard.multi;

import java.awt.event.KeyListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;


public class ClipboardHistoryPanel extends javax.swing.JPanel {
    public static final int ID_WIDTH = 30;

    public ClipboardHistoryPanel(ClipboardHistory clipboardHistory) {
        initComponents();

        final ClipboardHistoryTableModel model = new ClipboardHistoryTableModel(clipboardHistory.toList());
        clipboardEntries.setModel(model);

        TableColumn idColumn = clipboardEntries.getColumnModel().getColumn(0);
        idColumn.setWidth(ID_WIDTH);
        idColumn.setPreferredWidth(ID_WIDTH);
        idColumn.setMaxWidth(ID_WIDTH);
        idColumn.setMinWidth(ID_WIDTH);

        clipboardEntries.getColumnModel().getColumn(1).setCellRenderer(new ClipboardContentsCellRenderer());

        clipboardEntries.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String text = "";
                int row = clipboardEntries.getSelectedRow();
                if (row >= 0) {
                    text = model.getValueAt(row, 1).toString();
                }
                content.setText(text);
                content.setCaretPosition(0);
            }
        });

        for (KeyListener keyListener : clipboardEntries.getKeyListeners()) {
            clipboardEntries.removeKeyListener(keyListener);
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JSplitPane jSplitPane1 = new javax.swing.JSplitPane();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        clipboardEntries = new javax.swing.JTable();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        content = new javax.swing.JEditorPane();

        jSplitPane1.setDividerLocation(150);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        clipboardEntries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        clipboardEntries.setIntercellSpacing(new java.awt.Dimension(0, 0));
        clipboardEntries.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        clipboardEntries.setShowHorizontalLines(false);
        clipboardEntries.setShowVerticalLines(false);
        clipboardEntries.setSurrendersFocusOnKeystroke(true);
        clipboardEntries.setTableHeader(null);
        jScrollPane1.setViewportView(clipboardEntries);

        jSplitPane1.setTopComponent(jScrollPane1);

        content.setEditable(false);
        content.setFont(new java.awt.Font("Courier New", 0, 14));
        content.setFocusable(false);
        jScrollPane2.setViewportView(content);

        jSplitPane1.setRightComponent(jScrollPane2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(jSplitPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 451, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jSplitPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable clipboardEntries;
    private javax.swing.JEditorPane content;
    // End of variables declaration//GEN-END:variables

}
