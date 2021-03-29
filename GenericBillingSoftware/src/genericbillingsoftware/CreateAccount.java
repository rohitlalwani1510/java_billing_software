/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericbillingsoftware;

import java.awt.Color;
import java.awt.Cursor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author rohit
 */
public
        class CreateAccount extends javax.swing.JFrame {

    /**
     * Creates new form CreateAccount
     */
    private Color errorColor;
    public
            CreateAccount() {
//                System.out.println(System.getProperty("java.version"));
                errorColor = new Color(255, 186, 186);
        initComponents();
        createAccountName.getDocument().addDocumentListener(new DocumentListener(){
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
                    String regex = "^[a-zA-Z][a-zA-Z ]*[a-zA-Z]$";
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(createAccountName.getText());
                    if(!createAccountName.getText().equals("") && !m.matches())
                        createAccountName.setBackground(errorColor);
                    else
                        createAccountName.setBackground(Color.WHITE);
                }
        });
        createAccountEmail.getDocument().addDocumentListener(new DocumentListener(){
                    @Override
                    public
                    void insertUpdate(DocumentEvent e) {
                        myFunc();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void removeUpdate(DocumentEvent e) {
                        myFunc();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void changedUpdate(DocumentEvent e) {
                        myFunc();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    public void myFunc()
                    {
                        String regex = "^[a-zA-Z0-9]+[a-zA-Z0-9.]*[a-zA-Z0-9.]+@[a-zA-Z0-9]+.[a-zA-Z]+";
                        Pattern p = Pattern.compile(regex);
                        Matcher m = p.matcher(createAccountEmail.getText());
                        if(!createAccountEmail.getText().equals("") && !m.matches())
                            createAccountEmail.setBackground(errorColor);
                        else
                            createAccountEmail.setBackground(Color.WHITE);
                    }
        });
        createAccountPassword.getDocument().addDocumentListener(new DocumentListener(){
                    @Override
                    public
                    void insertUpdate(DocumentEvent e) {
                        myFunc();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void removeUpdate(DocumentEvent e) {
                        myFunc();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void changedUpdate(DocumentEvent e) {
                        myFunc();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    public void myFunc(){
                        if(createAccountPassword.getText().length()==0)
                        {
                            createAccountPassword.setBackground(Color.WHITE);
                            createAccountPasswordConfirm.setBackground(Color.WHITE);
                        }
                        else if(createAccountPassword.getText().length()<8)
                            createAccountPassword.setBackground(errorColor);
                        else
                        {
                            if(createAccountPasswordConfirm.getText().equals(""))
                            {
                                createAccountPassword.setBackground(Color.WHITE);
                                createAccountPasswordConfirm.setBackground(Color.WHITE);
                            }
                            else if(createAccountPassword.getText().equals(createAccountPasswordConfirm.getText()))
                            {
                                createAccountPassword.setBackground(Color.WHITE);
                                createAccountPasswordConfirm.setBackground(Color.WHITE);
                            }
                            else
                            {
                                createAccountPassword.setBackground(errorColor);
                                createAccountPasswordConfirm.setBackground(errorColor);
                            }
                                
                        }
                    }
        });
        createAccountPasswordConfirm.getDocument().addDocumentListener(new DocumentListener(){
                    @Override
                    public
                    void insertUpdate(DocumentEvent e) {
                        myFunc();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void removeUpdate(DocumentEvent e) {
                        myFunc();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public
                    void changedUpdate(DocumentEvent e) {
                        myFunc();
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    public void myFunc(){
                        if(createAccountPasswordConfirm.getText().length()==0)
                        {
                            createAccountPasswordConfirm.setBackground(Color.WHITE);
                            createAccountPassword.setBackground(Color.WHITE);
                        }
                        else if(createAccountPasswordConfirm.getText().length()<8)
                            createAccountPasswordConfirm.setBackground(errorColor);
                        else
                        {
                            if(createAccountPassword.getText().equals(""))
                            {
                                createAccountPassword.setBackground(Color.WHITE);
                                createAccountPasswordConfirm.setBackground(Color.WHITE);
                            }
                            else if(createAccountPassword.getText().equals(createAccountPasswordConfirm.getText()))
                            {
                                createAccountPassword.setBackground(Color.WHITE);
                                createAccountPasswordConfirm.setBackground(Color.WHITE);
                            }
                            else
                            {
                                createAccountPassword.setBackground(errorColor);
                                createAccountPasswordConfirm.setBackground(errorColor);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        createAccountName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        createAccountEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        createAccountShowPasswordConfirm = new javax.swing.JCheckBox();
        createAccountShowPassword = new javax.swing.JCheckBox();
        createAccountLogin = new javax.swing.JButton();
        creaetAccountOpenAccount = new javax.swing.JButton();
        createAccountClose = new javax.swing.JButton();
        createAccountPasswordConfirm = new javax.swing.JPasswordField();
        createAccountPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel1.setText("Create New Account");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 285, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Confirm Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 650, -1, -1));

        createAccountName.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        createAccountName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountNameActionPerformed(evt);
            }
        });
        getContentPane().add(createAccountName, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, 310, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, -1, -1));

        createAccountEmail.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        getContentPane().add(createAccountEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 490, 310, 60));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 580, -1, -1));

        createAccountShowPasswordConfirm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        createAccountShowPasswordConfirm.setText("Show Password");
        createAccountShowPasswordConfirm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                createAccountShowPasswordConfirmStateChanged(evt);
            }
        });
        getContentPane().add(createAccountShowPasswordConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 650, -1, -1));

        createAccountShowPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        createAccountShowPassword.setText("Show Password");
        createAccountShowPassword.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                createAccountShowPasswordStateChanged(evt);
            }
        });
        getContentPane().add(createAccountShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 580, -1, -1));

        createAccountLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        createAccountLogin.setText("LOGIN");
        createAccountLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                createAccountLoginMousePressed(evt);
            }
        });
        getContentPane().add(createAccountLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 790, 200, 40));

        creaetAccountOpenAccount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        creaetAccountOpenAccount.setText("OPEN ACCOUNT");
        creaetAccountOpenAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                creaetAccountOpenAccountMousePressed(evt);
            }
        });
        getContentPane().add(creaetAccountOpenAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 730, 200, 40));

        createAccountClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        createAccountClose.setText("CLOSE");
        createAccountClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                createAccountCloseMousePressed(evt);
            }
        });
        getContentPane().add(createAccountClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 730, 200, 40));

        createAccountPasswordConfirm.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        getContentPane().add(createAccountPasswordConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 630, 310, 60));

        createAccountPassword.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        getContentPane().add(createAccountPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 560, 310, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createAccountNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createAccountNameActionPerformed

    private void createAccountShowPasswordStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_createAccountShowPasswordStateChanged
        // TODO add your handling code here:
        if(createAccountShowPassword.isSelected())
            createAccountPassword.setEchoChar((char)0);
        else
            createAccountPassword.setEchoChar('*');
    }//GEN-LAST:event_createAccountShowPasswordStateChanged

    private void createAccountShowPasswordConfirmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_createAccountShowPasswordConfirmStateChanged
        // TODO add your handling code here:
        if(createAccountShowPasswordConfirm.isSelected())
            createAccountPasswordConfirm.setEchoChar((char)0);
        else
            createAccountPasswordConfirm.setEchoChar('*');
    }//GEN-LAST:event_createAccountShowPasswordConfirmStateChanged

    private void createAccountCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAccountCloseMousePressed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(null, "Are you sure to exit?", "Close", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(res==JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_createAccountCloseMousePressed

    private void createAccountLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAccountLoginMousePressed
        // TODO add your handling code here:
        new LogIn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_createAccountLoginMousePressed

    private void creaetAccountOpenAccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creaetAccountOpenAccountMousePressed
        // TODO add your handling code here:
        if(createAccountName.getBackground()==errorColor)
            JOptionPane.showMessageDialog(null, "Invalid Name"); // highlight if name not valid
        else if(createAccountEmail.getBackground()==errorColor)
            JOptionPane.showMessageDialog(null, "Invalid Email"); // highlight if email not valid
        else if(createAccountPassword.getText().length()<8 || createAccountPasswordConfirm.getText().length()<8)
            JOptionPane.showMessageDialog(null, "Password must be of at least 8 characters"); // highlight if password less than 8 char
        else if(!createAccountPassword.getText().equals(createAccountPasswordConfirm.getText()))
            JOptionPane.showMessageDialog(null, "Passwords don't match"); // highlight if password don't match
        else
        {
            // create account
            
            // account created message
//            JOptionPane.showMessageDialog(null, "Account created successfully! Click OK to go to LogIn Screen!");
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            String addAccountResult = SqlQueries.addAccount(createAccountName.getText(), createAccountEmail.getText(), createAccountPassword.getText());
            this.setCursor(Cursor.getDefaultCursor());
            if(addAccountResult.equals(Boolean.toString(true)))
            {
                JOptionPane.showMessageDialog(null, "Account created Successfully. Click OK to go to LogIn Page.");
                new LogIn().setVisible(true);
                this.dispose();
            }
            else
                JOptionPane.showMessageDialog(null, addAccountResult);
        }
    }//GEN-LAST:event_creaetAccountOpenAccountMousePressed

    /**
     * @param args the command line arguments
     */
    public static
            void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public
                    void run() {
                new CreateAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton creaetAccountOpenAccount;
    private javax.swing.JButton createAccountClose;
    private javax.swing.JTextField createAccountEmail;
    private javax.swing.JButton createAccountLogin;
    private javax.swing.JTextField createAccountName;
    private javax.swing.JPasswordField createAccountPassword;
    private javax.swing.JPasswordField createAccountPasswordConfirm;
    private javax.swing.JCheckBox createAccountShowPassword;
    private javax.swing.JCheckBox createAccountShowPasswordConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
