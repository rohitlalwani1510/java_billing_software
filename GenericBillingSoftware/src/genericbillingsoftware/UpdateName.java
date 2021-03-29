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
        class UpdateName extends javax.swing.JPanel {

    /**
     * Creates new form UpdateName
     */
    public Color errorColor;
    public
            UpdateName() {
        errorColor = new Color(255,186,186);
        initComponents();
        updateName.setEchoChar((char)0);
        updateName.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public
            void insertUpdate(DocumentEvent e) {
                myFunc();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void removeUpdate(DocumentEvent e) {
                myFunc();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void changedUpdate(DocumentEvent e) {
                myFunc();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            public void myFunc()
                {
                    String regex = "^[a-zA-Z ]*[a-zA-Z]$";
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(updateName.getText());
                    if(!updateName.getText().equals("") && !m.matches())
                        updateName.setBackground(errorColor);
                    else
                        updateName.setBackground(Color.WHITE);
                }
        });
        updateNamePassword.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public
            void insertUpdate(DocumentEvent e) {
                password();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void removeUpdate(DocumentEvent e) {
                password();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void changedUpdate(DocumentEvent e) {
                password();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            public void password()
                {
                    if(updateNamePassword.getText().length()==0 || updateNamePassword.getText().length()>7)
                        updateNamePassword.setBackground(Color.WHITE);
                    else
                        updateNamePassword.setBackground(errorColor);
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

        updateNameClose = new javax.swing.JButton();
        updateName = new javax.swing.JPasswordField();
        viewName3 = new javax.swing.JLabel();
        viewName4 = new javax.swing.JLabel();
        updateNameButton = new javax.swing.JButton();
        updateNameReset = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        updateNamePassword = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(204, 204, 255));

        updateNameClose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateNameClose.setText("Close");
        updateNameClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateNameCloseMousePressed(evt);
            }
        });

        updateName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        viewName3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        viewName3.setText("New Name:");

        viewName4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        viewName4.setText("Current Password:");

        updateNameButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateNameButton.setText("Update Name");
        updateNameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateNameButtonMousePressed(evt);
            }
        });
        updateNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateNameButtonActionPerformed(evt);
            }
        });

        updateNameReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateNameReset.setText("Reset");
        updateNameReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateNameResetMousePressed(evt);
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

        updateNamePassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(updateNameClose))
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(updateNameButton)
                .addGap(46, 46, 46)
                .addComponent(updateNameReset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(viewName4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(viewName3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(89, 89, 89)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateName)
                            .addComponent(updateNamePassword, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(updateNameClose)
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(viewName3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateName))
                        .addGap(66, 66, 66)
                        .addComponent(viewName4))
                    .addComponent(updateNamePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateNameReset))
                .addGap(0, 77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateNameCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateNameCloseMousePressed
        // TODO add your handling code here:
        JDialog dialog = (JDialog) this.getRootPane().getParent();
        StandardDashBoard db = (StandardDashBoard) dialog.getParent();
        db.setEnabled(true);
        db.setLoggedInName(updateName.getText());
        dialog.dispose();
    }//GEN-LAST:event_updateNameCloseMousePressed

    private void updateNameButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateNameButtonMousePressed
        // TODO add your handling code here:
        if(updateName.getBackground()==errorColor || updateName.getText().length()==0 ||
            updateNamePassword.getBackground()==errorColor || updateNamePassword.getText().length()==0)
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
            String updateNameResult = SqlQueries.changeName(email, updateNamePassword.getText(), updateName.getText());
            if(updateNameResult.equals("true"))
            {
                JLabel message = new JLabel("Name updated successfully!");
                message.setFont(new Font("Tahoma",0,18));
                JOptionPane.showMessageDialog(null, message);
                updateNameCloseMousePressed(null);
            }
            else
            {
                JLabel message = new JLabel(updateNameResult);
                message.setFont(new Font("Tahoma",0,18));
                JOptionPane.showMessageDialog(null, message);
            }
        }

    }//GEN-LAST:event_updateNameButtonMousePressed

    private void updateNameResetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateNameResetMousePressed
        // TODO add your handling code here:
        updateNamePassword.setText("");
        updateNamePassword.setBackground(Color.WHITE);
        updateName.setText("");
        updateName.setBackground(Color.WHITE);
    }//GEN-LAST:event_updateNameResetMousePressed

    private void updateNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateNameButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateNameButtonActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        if(jCheckBox1.isSelected())
            updateNamePassword.setEchoChar((char)0);
        else
            updateNamePassword.setEchoChar('*');
    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPasswordField updateName;
    private javax.swing.JButton updateNameButton;
    private javax.swing.JButton updateNameClose;
    private javax.swing.JPasswordField updateNamePassword;
    private javax.swing.JButton updateNameReset;
    private javax.swing.JLabel viewName3;
    private javax.swing.JLabel viewName4;
    // End of variables declaration//GEN-END:variables
}