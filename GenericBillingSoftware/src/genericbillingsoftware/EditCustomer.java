/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericbillingsoftware;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
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
        class EditCustomer extends javax.swing.JPanel {

    /**
     * Creates new form EditCustomer
     */
    public Color errorColor;
    public void getCustomers()
    {
        ArrayList<String[]> customers = SqlQueries.getCustomers();
        jComboBox1.removeAllItems();
        jComboBox1.addItem(null);
        for(String[] cur_customer:customers)
            jComboBox1.addItem(cur_customer[2]+","+cur_customer[0]);
        jComboBox1.setSelectedItem(null);
    }
    public
            EditCustomer() {
        errorColor = new Color(255, 186, 186);
        initComponents();
        customerResetMousePressed(null);
        getCustomers();
        newName.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public
            void insertUpdate(DocumentEvent e) {
                name();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void removeUpdate(DocumentEvent e) {
                name();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void changedUpdate(DocumentEvent e) {
                name();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            public void name()
                {
                    String regex = "^[a-zA-Z][a-zA-Z ]*[a-zA-Z]$";
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(newName.getText());
                    if(!newName.getText().equals("") && !m.matches())
                        newName.setBackground(errorColor);
                    else
                        newName.setBackground(Color.WHITE);
                }
        });
        newEmail.getDocument().addDocumentListener(new DocumentListener(){
                    @Override
                    public
                    void insertUpdate(DocumentEvent e) {
                        email();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void removeUpdate(DocumentEvent e) {
                        email();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void changedUpdate(DocumentEvent e) {
                        email();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    public void email()
                    {
                        String regex = "^[a-zA-Z0-9]+[a-zA-Z0-9.]*[a-zA-Z0-9.]+@[a-zA-Z0-9]+.[a-zA-Z]+";
                        Pattern p = Pattern.compile(regex);
                        Matcher m = p.matcher(newEmail.getText());
                        if(!newEmail.getText().equals("") && !m.matches())
                            newEmail.setBackground(errorColor);
                        else
                            newEmail.setBackground(Color.WHITE);
                    }
        });
        newPhone.getDocument().addDocumentListener(new DocumentListener(){
                    @Override
                    public
                    void insertUpdate(DocumentEvent e) {
                        change();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void removeUpdate(DocumentEvent e) {
                        change();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void changedUpdate(DocumentEvent e) {
                        change();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    public void change()
                    {
                        String regex = "[0-9]{10}";
                        Pattern p = Pattern.compile(regex);
                        Matcher m = p.matcher(newPhone.getText());
                        if(!newPhone.getText().equals("") && !m.matches())
                        {
                            newPhone.setBackground(errorColor);
                        }
                        else
                        {
                            newPhone.setBackground(Color.WHITE);
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

        editCustomerClose = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        curEmail = new javax.swing.JTextField();
        updatePhone = new javax.swing.JCheckBox();
        updateName = new javax.swing.JCheckBox();
        updateEmail = new javax.swing.JCheckBox();
        updateCustomer = new javax.swing.JButton();
        newPhone = new javax.swing.JTextField();
        newName = new javax.swing.JTextField();
        customerReset = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        curPhone = new javax.swing.JTextField();
        curName = new javax.swing.JTextField();
        newEmail = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 255));

        editCustomerClose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        editCustomerClose.setText("Close");
        editCustomerClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editCustomerCloseMousePressed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Select Customer");

        curEmail.setEditable(false);
        curEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        updatePhone.setBackground(new java.awt.Color(204, 204, 255));
        updatePhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updatePhone.setText("Update Phone");
        updatePhone.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                updatePhoneItemStateChanged(evt);
            }
        });

        updateName.setBackground(new java.awt.Color(204, 204, 255));
        updateName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateName.setText("Update Name");
        updateName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                updateNameItemStateChanged(evt);
            }
        });

        updateEmail.setBackground(new java.awt.Color(204, 204, 255));
        updateEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateEmail.setText("Update Email");
        updateEmail.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                updateEmailItemStateChanged(evt);
            }
        });

        updateCustomer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateCustomer.setText("Update Customers");
        updateCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateCustomerMousePressed(evt);
            }
        });

        newPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        newName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        customerReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        customerReset.setText("Reset");
        customerReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                customerResetMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Current Name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Current Phone:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Current Email:");

        curPhone.setEditable(false);
        curPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        curName.setEditable(false);
        curName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        newEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(editCustomerClose))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(curName, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(curEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(curPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(updateName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(updatePhone))
                            .addComponent(updateEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newName, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(updateCustomer)
                        .addGap(78, 78, 78)
                        .addComponent(customerReset))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(editCustomerClose)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(curName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(curPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(curEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updatePhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateCustomer)
                    .addComponent(customerReset))
                .addGap(58, 58, 58))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editCustomerCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editCustomerCloseMousePressed
        // TODO add your handling code here:
        JDialog dialog = (JDialog) this.getRootPane().getParent();
        dialog.getParent().setEnabled(true);
        dialog.dispose();
    }//GEN-LAST:event_editCustomerCloseMousePressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedItem()==null)
            customerResetMousePressed(null);
        else
        {
            updateName.setEnabled(true);
            updatePhone.setEnabled(true);
            updateEmail.setEnabled(true);
            String cur = (String) jComboBox1.getSelectedItem();
            String[] cur1 = cur.split(",");
            String[] customer = SqlQueries.getCustomer(cur1[0]);
            curEmail.setText(customer[1]);
            curName.setText(customer[0]);
            curPhone.setText(customer[2]);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void updatePhoneItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_updatePhoneItemStateChanged
        // TODO add your handling code here:
        if(updatePhone.isSelected())
            newPhone.setEnabled(true);
        else {
            newPhone.setEnabled(false);
            newPhone.setText("");
        }
    }//GEN-LAST:event_updatePhoneItemStateChanged

    private void updateNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_updateNameItemStateChanged
        // TODO add your handling code here:
        if(updateName.isSelected())
            newName.setEnabled(true);
        else {
            newName.setEnabled(false);
            newName.setText("");
        }
    }//GEN-LAST:event_updateNameItemStateChanged

    private void updateEmailItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_updateEmailItemStateChanged
        // TODO add your handling code here:
        if(updateEmail.isSelected())
            newEmail.setEnabled(true);
        else {
            newEmail.setEnabled(false);
            newEmail.setText("");
        }
    }//GEN-LAST:event_updateEmailItemStateChanged

    private void updateCustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateCustomerMousePressed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedItem()==null)
        {
            JLabel message = new JLabel("Invalid details!");
            message.setFont(new Font("Tahoma", 0, 18));
            JOptionPane.showMessageDialog(null, message);
        }
        else
        {
            if((updateName.isSelected() && (newName.getText().length()==0 || newName.getBackground()==errorColor)) ||
                (updatePhone.isSelected() && (newPhone.getText().length()==0)) ||
                (updateEmail.isSelected() && (newEmail.getBackground()==errorColor)))
            {
                JLabel message = new JLabel("Invalid details!");
                message.setFont(new Font("Tahoma",0,18));
                JOptionPane.showMessageDialog(null, message);
            }
            else
            {
                if(updateName.isSelected()==false && updatePhone.isSelected()==false &&
                    updateEmail.isSelected()==false)
                {
                    JLabel message = new JLabel("No change in Customer!");
                    message.setFont(new Font("Tahoma",0,18));
                    JOptionPane.showMessageDialog(null, message);
                }
                else {
                    String toBeName=(updateName.isSelected())?newName.getText():curName.getText(),
                    toBePhone=(updatePhone.isSelected())?newPhone.getText():curPhone.getText(),
                    toBeEmail=(updateEmail.isSelected())?newEmail.getText():curEmail.getText();
                    String updateCustomerResult = SqlQueries.updateCustomer(curPhone.getText(), toBeName, toBePhone, toBeEmail);
                    if(updateCustomerResult.equals(Boolean.toString(true)))
                    {
                        JLabel message = new JLabel("Customer updated successfully!");
                        message.setFont(new Font("Tahoma",0,18));
                        getCustomers();
                        customerResetMousePressed(null);
                        JOptionPane.showMessageDialog(null, message);
                    }
                    else
                    {
                        JLabel message = new JLabel(updateCustomerResult);
                        message.setFont(new Font("Tahoma",0,18));
                        JOptionPane.showMessageDialog(null, message);
                    }
                }
            }
        }
    }//GEN-LAST:event_updateCustomerMousePressed

    private void customerResetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerResetMousePressed
        // TODO add your handling code here:
        jComboBox1.setSelectedItem(null);
        curName.setText("");
        curEmail.setText("");
        curPhone.setText("");
        updateName.setSelected(false);
        updatePhone.setSelected(false);
        updateEmail.setSelected(false);
        curName.setBackground(new Color(240,240,240));
        curPhone.setBackground(new Color(240,240,240));
        curEmail.setBackground(new Color(240,240,240));
        newName.setText("");
        newPhone.setText("");
        newEmail.setText("");
        newName.setEnabled(false);
        newPhone.setEnabled(false);
        newEmail.setEnabled(false);
        updateEmail.setEnabled(false);
        updatePhone.setEnabled(false);
        updateName.setEnabled(false);
    }//GEN-LAST:event_customerResetMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField curEmail;
    private javax.swing.JTextField curName;
    private javax.swing.JTextField curPhone;
    private javax.swing.JButton customerReset;
    private javax.swing.JButton editCustomerClose;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField newEmail;
    private javax.swing.JTextField newName;
    private javax.swing.JTextField newPhone;
    private javax.swing.JButton updateCustomer;
    private javax.swing.JCheckBox updateEmail;
    private javax.swing.JCheckBox updateName;
    private javax.swing.JCheckBox updatePhone;
    // End of variables declaration//GEN-END:variables
}
