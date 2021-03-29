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
        class AddCustomer extends javax.swing.JPanel {

    /**
     * Creates new form AddCustomer
     */
    public Color errorColor;
    public
            AddCustomer() {
        errorColor = new Color(255, 186, 186);
        initComponents();
        addCustomerEmail.setEnabled(false);
        addCustomerName.getDocument().addDocumentListener(new DocumentListener(){
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
                    Matcher m = p.matcher(addCustomerName.getText());
                    if(!addCustomerName.getText().equals("") && !m.matches())
                        addCustomerName.setBackground(errorColor);
                    else
                        addCustomerName.setBackground(Color.WHITE);
                }
        });
        addCustomerEmail.getDocument().addDocumentListener(new DocumentListener(){
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
                        Matcher m = p.matcher(addCustomerEmail.getText());
                        if(!addCustomerEmail.getText().equals("") && !m.matches())
                            addCustomerEmail.setBackground(errorColor);
                        else
                            addCustomerEmail.setBackground(Color.WHITE);
                    }
        });
        addCustomerPhone.getDocument().addDocumentListener(new DocumentListener(){
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
                        Matcher m = p.matcher(addCustomerPhone.getText());
                        if(!addCustomerPhone.getText().equals("") && !m.matches())
                        {
                            addCustomerPhone.setBackground(errorColor);
                        }
                        else
                        {
                            addCustomerPhone.setBackground(Color.WHITE);
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

        itemClose = new javax.swing.JButton();
        addCustomerEmailCheckBox = new javax.swing.JCheckBox();
        addCustomerName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        addCustomerPhone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addCustomerEmail = new javax.swing.JTextField();
        addCustomerButton = new javax.swing.JButton();
        addCustomerReset = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        itemClose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        itemClose.setText("Close");
        itemClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemCloseMousePressed(evt);
            }
        });

        addCustomerEmailCheckBox.setBackground(new java.awt.Color(204, 204, 255));
        addCustomerEmailCheckBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addCustomerEmailCheckBox.setText("Add Email");
        addCustomerEmailCheckBox.setDoubleBuffered(true);
        addCustomerEmailCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                addCustomerEmailCheckBoxItemStateChanged(evt);
            }
        });

        addCustomerName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Customer Name");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        addCustomerPhone.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Customer Phone");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Customer Email");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        addCustomerEmail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        addCustomerButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addCustomerButton.setText("Add Customer");
        addCustomerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addCustomerButtonMousePressed(evt);
            }
        });

        addCustomerReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addCustomerReset.setText("Reset");
        addCustomerReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addCustomerResetMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(itemClose))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(addCustomerButton)
                .addGap(61, 61, 61)
                .addComponent(addCustomerReset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addCustomerEmailCheckBox))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(addCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addCustomerName)
                                    .addComponent(addCustomerPhone))))))
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(itemClose)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(addCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(addCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(addCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCustomerEmailCheckBox)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCustomerButton)
                    .addComponent(addCustomerReset))
                .addGap(0, 35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void itemCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemCloseMousePressed
        // TODO add your handling code here:
        JDialog dialog = (JDialog) this.getRootPane().getParent();
        dialog.getParent().setEnabled(true);
        dialog.dispose();
    }//GEN-LAST:event_itemCloseMousePressed

    private void addCustomerButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCustomerButtonMousePressed
        // TODO add your handling code here:
        if(addCustomerName.getText().length()==0 || addCustomerName.getBackground()==errorColor ||
           addCustomerEmail.getBackground()==errorColor ||
           addCustomerPhone.getBackground()==errorColor || addCustomerPhone.getText().length()==0)
        {
            JLabel message = new JLabel("Invalid details");
            message.setFont(new Font("Tahoma",0,18));
            JOptionPane.showMessageDialog(null, message);
        }
        else
        {
            JLabel message = new JLabel("Customer added successfully");
            message.setFont(new Font("Tahoma",0,18));
            String addCustomerResult = SqlQueries.addCustomer(addCustomerName.getText(), addCustomerPhone.getText(), addCustomerEmail.getText());
            if(addCustomerResult.equals("true"))
            {
                addCustomerResetMousePressed(null);
                JOptionPane.showMessageDialog(null, message);
            }
            else
            {
                message.setText(addCustomerResult);
                JOptionPane.showMessageDialog(null, message);
            }
        }
    }//GEN-LAST:event_addCustomerButtonMousePressed

    private void addCustomerResetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCustomerResetMousePressed
        // TODO add your handling code here:
        addCustomerName.setText("");
        addCustomerName.setBackground(Color.WHITE);
        addCustomerEmail.setText("");
        addCustomerEmail.setBackground(Color.WHITE);
        addCustomerPhone.setText("");
        addCustomerPhone.setBackground(Color.WHITE);
        addCustomerEmail.setEnabled(false);
        addCustomerEmailCheckBox.setSelected(false);
    }//GEN-LAST:event_addCustomerResetMousePressed

    private void addCustomerEmailCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_addCustomerEmailCheckBoxItemStateChanged
        // TODO add your handling code here:
        if(addCustomerEmailCheckBox.isSelected())
            addCustomerEmail.setEnabled(true);
        else
        {
            addCustomerEmail.setBackground(Color.WHITE);
            addCustomerEmail.setText("");
            addCustomerEmail.setEnabled(false);
        }
    }//GEN-LAST:event_addCustomerEmailCheckBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCustomerButton;
    private javax.swing.JTextField addCustomerEmail;
    private javax.swing.JCheckBox addCustomerEmailCheckBox;
    private javax.swing.JTextField addCustomerName;
    private javax.swing.JTextField addCustomerPhone;
    private javax.swing.JButton addCustomerReset;
    private javax.swing.JButton itemClose;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
