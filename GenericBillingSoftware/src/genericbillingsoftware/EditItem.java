/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericbillingsoftware;

import java.awt.Color;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author rohit
 */
public
        class EditItem extends javax.swing.JPanel {

    private
    Color errorColor;

    /**
     * Creates new form addItem
     */
    public void getItemsID()
    {
        Object[] items = SqlQueries.getItems(SqlQueries.INT_TYPE);
        jComboBox1.removeAllItems();
        jComboBox1.addItem(null);
        for(Object item:items)
            jComboBox1.addItem((String) item);
        jComboBox1.setSelectedItem(null);
    }
    public void getItemsName()
    {
        Object[] items = SqlQueries.getItems(SqlQueries.STRING_TYPE);
        jComboBox2.removeAllItems();
        jComboBox2.addItem(null);
        for(Object item:items)
            jComboBox2.addItem((String) item);
        jComboBox2.setSelectedItem(null);
    }
    public
            EditItem() {
        errorColor = new Color(255,186,186);
        initComponents();
        getItemsID();
        getItemsName();
        itemResetMousePressed(null);
        newCost.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public
            void insertUpdate(DocumentEvent e) {
                checkFloat();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void removeUpdate(DocumentEvent e) {
                checkFloat();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void changedUpdate(DocumentEvent e) {
                checkFloat();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            public void checkFloat()
                {
                    String regex = "([0-9]*[.])?[0-9]+";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(newCost.getText());
                    if(matcher.matches() || newCost.getText().length()==0)
                        newCost.setBackground(Color.WHITE);
                    else
                        newCost.setBackground(errorColor);
                }
        });
        newID.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public
            void insertUpdate(DocumentEvent e) {
                checkID();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void removeUpdate(DocumentEvent e) {
                checkID();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void changedUpdate(DocumentEvent e) {
                checkID();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            public void checkID()
            {
                try {
                    Integer.parseInt(newID.getText());
                    newID.setBackground(Color.WHITE);
                }
                catch(Exception error)
                {
                    if(newID.getText().length()==0)
                        newID.setBackground(Color.WHITE);
                    else
                        newID.setBackground(errorColor);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        itemAdd = new javax.swing.JButton();
        updateActive = new javax.swing.JCheckBox();
        itemReset = new javax.swing.JButton();
        itemClose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        newCost = new javax.swing.JTextField();
        updateName = new javax.swing.JCheckBox();
        updateID = new javax.swing.JCheckBox();
        updateCost = new javax.swing.JCheckBox();
        newName = new javax.swing.JTextField();
        newID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        curName = new javax.swing.JTextField();
        curID = new javax.swing.JTextField();
        curCost = new javax.swing.JTextField();
        curActive13 = new javax.swing.JLabel();
        curActive = new javax.swing.JTextField();
        noRadio = new javax.swing.JRadioButton();
        yesRadio = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OR      Name");

        itemAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        itemAdd.setText("Update Item");
        itemAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemAddMousePressed(evt);
            }
        });

        updateActive.setBackground(new java.awt.Color(204, 204, 255));
        updateActive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateActive.setText("Update Active");
        updateActive.setDoubleBuffered(true);
        updateActive.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                updateActiveItemStateChanged(evt);
            }
        });

        itemReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        itemReset.setText("Reset");
        itemReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemResetMousePressed(evt);
            }
        });

        itemClose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        itemClose.setText("Close");
        itemClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemCloseMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Select      ID");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        newCost.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        updateName.setBackground(new java.awt.Color(204, 204, 255));
        updateName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateName.setText("Update Name");
        updateName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                updateNameItemStateChanged(evt);
            }
        });

        updateID.setBackground(new java.awt.Color(204, 204, 255));
        updateID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateID.setText("Update ID");
        updateID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                updateIDItemStateChanged(evt);
            }
        });

        updateCost.setBackground(new java.awt.Color(204, 204, 255));
        updateCost.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateCost.setText("Update Cost");
        updateCost.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                updateCostItemStateChanged(evt);
            }
        });

        newName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        newID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Current ID:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Current Name:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Current Cost:");

        curName.setEditable(false);
        curName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        curID.setEditable(false);
        curID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        curCost.setEditable(false);
        curCost.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        curActive13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        curActive13.setText("Current Active:");

        curActive.setEditable(false);
        curActive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        curActive.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        noRadio.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(noRadio);
        noRadio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        noRadio.setText("NO");

        yesRadio.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(yesRadio);
        yesRadio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        yesRadio.setText("YES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(curActive13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(curActive, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(curID, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(curCost, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(curName, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updateID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateName))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newName, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newID, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updateCost, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateActive))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newCost, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(yesRadio)
                                        .addGap(44, 44, 44)
                                        .addComponent(noRadio))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemClose, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(itemAdd)
                        .addGap(78, 78, 78)
                        .addComponent(itemReset)
                        .addGap(221, 221, 221))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(itemClose)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(curID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(curName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(curCost, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(curActive13)
                            .addComponent(curActive, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newCost, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateActive)
                            .addComponent(noRadio)
                            .addComponent(yesRadio))
                        .addGap(25, 25, 25)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemAdd)
                    .addComponent(itemReset))
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void itemAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemAddMousePressed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedItem()==null || jComboBox2.getSelectedItem()==null)
        {
            JLabel message = new JLabel();
            message.setText("Invalid details!");
            message.setFont(new Font("Tahoma", 0, 18));
            JOptionPane.showMessageDialog(null, message);
        }
        else
        {
            if((updateID.isSelected() && (newID.getText().length()==0 || newID.getBackground()==errorColor)) ||
                (updateName.isSelected() && (newName.getText().trim().length()==0)) || 
                (updateCost.isSelected() && (newCost.getText().length()==0 || newCost.getBackground()==errorColor)) ||
                (updateActive.isSelected() && (yesRadio.isSelected()==false && noRadio.isSelected()==false)))
            {
                JLabel message = new JLabel("Invalid details!");
                message.setFont(new Font("Tahoma",0,18));
                JOptionPane.showMessageDialog(null, message);
            }
            else
            {
                if(updateID.isSelected()==false && updateName.isSelected()==false && 
                   updateCost.isSelected()==false && updateActive.isSelected()==false)
                {
                    JLabel message = new JLabel("No change in Item!");
                    message.setFont(new Font("Tahoma",0,18));
                    JOptionPane.showMessageDialog(null, message);
                }
                else {
                    String toBeID=(updateID.isSelected())?newID.getText():curID.getText(),
                        toBeName=(updateName.isSelected())?newName.getText().trim():curName.getText(),
                        toBeCost=(updateCost.isSelected())?newCost.getText():curCost.getText(),
                        toBeActive=(updateActive.isSelected())?(yesRadio.isSelected()?"true":"false"):("YES".equals(curActive.getText()))?"true":"false";
    //                this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    String updateResult = SqlQueries.updateItem(toBeID, toBeName, toBeCost, toBeActive, curID.getText());
    //                this.setCursor(Cursor.getDefaultCursor());
                    if(updateResult.equals(Boolean.toString(true)))
                    {
                        JLabel message = new JLabel("Item updated successfully!");
                        message.setFont(new Font("Tahoma",0,18));
                        getItemsID();
                        getItemsName();
                        itemResetMousePressed(null);
                        JOptionPane.showMessageDialog(null, message);
                    }
                    else
                    {
                        JLabel message = new JLabel(updateResult);
                        message.setFont(new Font("Tahoma",0,18));
                        JOptionPane.showMessageDialog(null, message);
                    }
                }
            }
        }
    }//GEN-LAST:event_itemAddMousePressed

    private void itemResetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemResetMousePressed
        // TODO add your handling code here:
        jComboBox1.setSelectedItem(null);
        jComboBox2.setSelectedItem(null);
        curID.setText("");
        curCost.setText("");
        curName.setText("");
        updateID.setSelected(false);
        updateName.setSelected(false);
        updateCost.setSelected(false);
        curID.setBackground(new Color(240,240,240));
        curName.setBackground(new Color(240,240,240));
        curCost.setBackground(new Color(240,240,240));
        curActive.setBackground(new Color(240,240,240));
        newID.setText("");
        newName.setText("");
        newCost.setText("");
        curActive.setText("");
        updateActive.setSelected(false);
        buttonGroup1.clearSelection();
        newID.setEnabled(false);
        newName.setEnabled(false);
        newCost.setEnabled(false);
        yesRadio.setEnabled(false);
        noRadio.setEnabled(false);
        updateActive.setEnabled(false);
        updateCost.setEnabled(false);
        updateName.setEnabled(false);
        updateID.setEnabled(false);
    }//GEN-LAST:event_itemResetMousePressed

    private void itemCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemCloseMousePressed
        // TODO add your handling code here:
        JDialog dialog = (JDialog) this.getRootPane().getParent();
        dialog.getParent().setEnabled(true);
        dialog.dispose();
    }//GEN-LAST:event_itemCloseMousePressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedItem()==null)
            itemResetMousePressed(null);
        else
        {
            updateActive.setEnabled(true);
            updateID.setEnabled(true);
            updateName.setEnabled(true);
            updateCost.setEnabled(true);
            ItemObject item = SqlQueries.getItemFromID((String) jComboBox1.getSelectedItem());
            jComboBox2.setSelectedItem(item.getName());
            curCost.setText(item.getCost());
            curID.setText(item.getID());
            curName.setText(item.getName());
            if(item.isActive().equals("true"))
                curActive.setText("YES");
            else
                curActive.setText("NO");
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        if(jComboBox2.getSelectedItem()==null)
            itemResetMousePressed(null);
        else
        {
            updateActive.setEnabled(true);
            updateID.setEnabled(true);
            updateName.setEnabled(true);
            updateCost.setEnabled(true);
            ItemObject item = SqlQueries.getItemFromName((String) jComboBox2.getSelectedItem());
            jComboBox1.setSelectedItem(item.getID());
            curCost.setText(item.getCost());
            curID.setText(item.getID());
            curName.setText(item.getName());
            if(item.isActive().equals("true"))
                curActive.setText("YES");
            else
                curActive.setText("NO");
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void updateIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_updateIDItemStateChanged
        // TODO add your handling code here:
        if(updateID.isSelected())
            newID.setEnabled(true);
        else {
            newID.setEnabled(false);
            newID.setText("");
        }
    }//GEN-LAST:event_updateIDItemStateChanged

    private void updateNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_updateNameItemStateChanged
        // TODO add your handling code here:
        if(updateName.isSelected())
            newName.setEnabled(true);
        else {
            newName.setEnabled(false);
            newName.setText("");
        }
    }//GEN-LAST:event_updateNameItemStateChanged

    private void updateCostItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_updateCostItemStateChanged
        // TODO add your handling code here:
        if(updateCost.isSelected())
            newCost.setEnabled(true);
        else {
            newCost.setEnabled(false);
            newCost.setText("");
        }
    }//GEN-LAST:event_updateCostItemStateChanged

    private void updateActiveItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_updateActiveItemStateChanged
        // TODO add your handling code here:
        if(updateActive.isSelected()) {
            yesRadio.setEnabled(true);
            noRadio.setEnabled(true);
        }
        else {
            yesRadio.setEnabled(false);
            noRadio.setEnabled(false);
            buttonGroup1.clearSelection();
        }
    }//GEN-LAST:event_updateActiveItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField curActive;
    private javax.swing.JLabel curActive13;
    private javax.swing.JTextField curCost;
    private javax.swing.JTextField curID;
    private javax.swing.JTextField curName;
    private javax.swing.JButton itemAdd;
    private javax.swing.JButton itemClose;
    private javax.swing.JButton itemReset;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField newCost;
    private javax.swing.JTextField newID;
    private javax.swing.JTextField newName;
    private javax.swing.JRadioButton noRadio;
    private javax.swing.JCheckBox updateActive;
    private javax.swing.JCheckBox updateCost;
    private javax.swing.JCheckBox updateID;
    private javax.swing.JCheckBox updateName;
    private javax.swing.JRadioButton yesRadio;
    // End of variables declaration//GEN-END:variables
}
