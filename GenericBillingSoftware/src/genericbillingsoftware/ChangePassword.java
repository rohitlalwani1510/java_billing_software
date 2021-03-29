/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericbillingsoftware;

import java.awt.Color;
import java.awt.Font;
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
        class ChangePassword extends javax.swing.JPanel {

    /**
     * Creates new form ChangePassword
     */
    public static Color errorColor;
    public
            ChangePassword() {
                errorColor = new Color(255,186,186);
        initComponents();
        changePasswordOld.getDocument().addDocumentListener(new DocumentListener(){
                    @Override
                    public
                    void insertUpdate(DocumentEvent e) {
                        check();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void removeUpdate(DocumentEvent e) {
                        check();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void changedUpdate(DocumentEvent e) {
                        check();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    public void check()
                {
                    if(changePasswordOld.getText().length()==0 || changePasswordOld.getText().length()>=8)
                {
                    changePasswordOld.setBackground(Color.WHITE);
                    if(changePasswordOld.getText().length()>=8)
                    {
                        if(changePasswordOld.getText().equals(changePasswordNew.getText()))
                            changePasswordNew.setBackground(errorColor);
                        else
                            changePasswordNew.setBackground(Color.WHITE);
                        if(changePasswordOld.getText().equals(changePasswordConfirm.getText()))
                            changePasswordConfirm.setBackground(errorColor);
                        else
                            changePasswordConfirm.setBackground(Color.WHITE);
                    }
                }
                    else
                {
                    changePasswordOld.setBackground(errorColor);
                }
                }
        });
        changePasswordNew.getDocument().addDocumentListener(new DocumentListener(){
                    @Override
                    public
                    void insertUpdate(DocumentEvent e) {
                        check();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void removeUpdate(DocumentEvent e) {
                        check();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void changedUpdate(DocumentEvent e) {
                        check();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    public void check()
                {
                    if(changePasswordNew.getText().length()==0)
                    {
                        changePasswordNew.setBackground(Color.WHITE);
                    }
                    else if(changePasswordNew.getText().length()<8)
                        changePasswordNew.setBackground(errorColor);
                    else if(changePasswordOld.getText().equals(changePasswordNew.getText()))
                        changePasswordNew.setBackground(errorColor);
                    else
                    {
                        if(changePasswordConfirm.getText().length()==0)
                        {
                            changePasswordConfirm.setBackground(Color.WHITE);
                            changePasswordNew.setBackground(Color.WHITE);
                        }
                        else if(!changePasswordNew.getText().equals(changePasswordConfirm.getText()))
                        {
                            changePasswordConfirm.setBackground(errorColor);
                            changePasswordNew.setBackground(errorColor);
                        }
                        else
                        {
                            changePasswordConfirm.setBackground(Color.WHITE);
                            changePasswordNew.setBackground(Color.WHITE);
                        }
                    }
                }
        });
        changePasswordConfirm.getDocument().addDocumentListener(new DocumentListener(){
                    @Override
                    public
                    void insertUpdate(DocumentEvent e) {
                        check();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void removeUpdate(DocumentEvent e) {
                        check();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void changedUpdate(DocumentEvent e) {
                        check();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    public void check()
                {
                    if(changePasswordConfirm.getText().length()==0)
                    {
                        changePasswordConfirm.setBackground(Color.WHITE);
                    }
                    else if(changePasswordConfirm.getText().length()<8)
                        changePasswordConfirm.setBackground(errorColor);
                    else if(changePasswordConfirm.getText().equals(changePasswordOld.getText()))
                        changePasswordConfirm.setBackground(errorColor);
                    else
                    {
                        if(changePasswordNew.getText().length()==0)
                        {
                            changePasswordConfirm.setBackground(Color.WHITE);
                            changePasswordNew.setBackground(Color.WHITE);
                        }
                        else if(!changePasswordNew.getText().equals(changePasswordConfirm.getText()))
                        {
                            changePasswordConfirm.setBackground(errorColor);
                            changePasswordNew.setBackground(errorColor);
                        }
                        else
                        {
                            changePasswordConfirm.setBackground(Color.WHITE);
                            changePasswordNew.setBackground(Color.WHITE);
                        }
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

        changePasswordClose = new javax.swing.JButton();
        viewName3 = new javax.swing.JLabel();
        viewName4 = new javax.swing.JLabel();
        viewName5 = new javax.swing.JLabel();
        changePasswordNew = new javax.swing.JPasswordField();
        changePasswordOld = new javax.swing.JPasswordField();
        changePasswordConfirm = new javax.swing.JPasswordField();
        changePasswordButton = new javax.swing.JButton();
        changePasswordReset = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(204, 204, 255));

        changePasswordClose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        changePasswordClose.setText("Close");
        changePasswordClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                changePasswordCloseMousePressed(evt);
            }
        });

        viewName3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        viewName3.setText("Old Password:");

        viewName4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        viewName4.setText("Confirm Password:");

        viewName5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        viewName5.setText("New Password:");

        changePasswordNew.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        changePasswordOld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        changePasswordConfirm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        changePasswordButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        changePasswordButton.setText("Change Password");
        changePasswordButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                changePasswordButtonMousePressed(evt);
            }
        });

        changePasswordReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        changePasswordReset.setText("Reset");
        changePasswordReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                changePasswordResetMousePressed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox1.setText("Show Password");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jCheckBox2.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox2.setText("Show Password");
        jCheckBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox2ItemStateChanged(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox3.setText("Show Password");
        jCheckBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox3ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(changePasswordClose))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(changePasswordButton)
                        .addGap(46, 46, 46)
                        .addComponent(changePasswordReset))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(viewName4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(viewName5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(viewName3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(changePasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(changePasswordNew, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(changePasswordOld, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox3))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(changePasswordClose)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewName3)
                    .addComponent(changePasswordOld, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewName5)
                    .addComponent(changePasswordNew, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(viewName4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changePasswordConfirm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changePasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changePasswordReset))
                .addGap(57, 57, 57))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void changePasswordCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswordCloseMousePressed
        // TODO add your handling code here:
        JDialog dialog = (JDialog) this.getRootPane().getParent();
        dialog.getParent().setEnabled(true);
        dialog.dispose();
    }//GEN-LAST:event_changePasswordCloseMousePressed

    private void changePasswordButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswordButtonMousePressed
        // TODO add your handling code here:
        if(changePasswordOld.getBackground()==errorColor || changePasswordOld.getText().length()==0 ||
           changePasswordNew.getBackground()==errorColor || changePasswordNew.getText().length()==0 ||
           changePasswordConfirm.getBackground()==errorColor || changePasswordConfirm.getText().length()==0)
        {
            JLabel message = new JLabel("Invalid password!");
            message.setFont(new Font("Tahoma",0,18));
            JOptionPane.showMessageDialog(null, message);
        }
        else
        {
            JDialog dialog = (JDialog) this.getRootPane().getParent();
            StandardDashBoard db = (StandardDashBoard) dialog.getParent();
            String email = db.getLoggedInEmail();
            String updatePassword = SqlQueries.changePassword(email, changePasswordOld.getText(), changePasswordNew.getText());
            if(updatePassword.equals("true"))
            {
                JLabel message = new JLabel("Password updated successfully!");
                message.setFont(new Font("Tahoma",0,18));
                JOptionPane.showMessageDialog(null, message);
                changePasswordCloseMousePressed(null);
            }
            else
            {
                JLabel message = new JLabel(updatePassword);
                message.setFont(new Font("Tahoma",0,18));
                JOptionPane.showMessageDialog(null, message);
            }
        }
        
    }//GEN-LAST:event_changePasswordButtonMousePressed

    private void changePasswordResetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswordResetMousePressed
        // TODO add your handling code here:
        changePasswordOld.setText("");
        changePasswordOld.setBackground(Color.WHITE);
        changePasswordNew.setText("");
        changePasswordNew.setBackground(Color.WHITE);
        changePasswordConfirm.setText("");
        changePasswordConfirm.setBackground(Color.WHITE);
    }//GEN-LAST:event_changePasswordResetMousePressed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        if(jCheckBox1.isSelected())
            changePasswordOld.setEchoChar((char)0);
        else
            changePasswordOld.setEchoChar('*');
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jCheckBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox2ItemStateChanged
        // TODO add your handling code here:
        if(jCheckBox2.isSelected())
            changePasswordNew.setEchoChar((char)0);
        else
            changePasswordNew.setEchoChar('*');
    }//GEN-LAST:event_jCheckBox2ItemStateChanged

    private void jCheckBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox3ItemStateChanged
        // TODO add your handling code here:
        if(jCheckBox3.isSelected())
            changePasswordConfirm.setEchoChar((char)0);
        else
            changePasswordConfirm.setEchoChar('*');
    }//GEN-LAST:event_jCheckBox3ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JButton changePasswordClose;
    private javax.swing.JPasswordField changePasswordConfirm;
    private javax.swing.JPasswordField changePasswordNew;
    private javax.swing.JPasswordField changePasswordOld;
    private javax.swing.JButton changePasswordReset;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel viewName3;
    private javax.swing.JLabel viewName4;
    private javax.swing.JLabel viewName5;
    // End of variables declaration//GEN-END:variables
}
