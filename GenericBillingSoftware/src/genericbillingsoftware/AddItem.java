/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericbillingsoftware;

import java.awt.Color;
import java.awt.Cursor;
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
        class AddItem extends javax.swing.JPanel {

    private
    Color errorColor;

    /**
     * Creates new form addItem
     */
    public
            AddItem() {
        errorColor = new Color(255,186,186);
        initComponents();
        itemName.getDocument().addDocumentListener(new DocumentListener(){
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
                    String regex = "^[a-zA-Z0-9][a-zA-Z0-9 ]*[a-zA-Z0-9]$";
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(itemName.getText());
                    if(!itemName.getText().equals("") && !m.matches())
                        itemName.setBackground(errorColor);
                    else
                        itemName.setBackground(Color.WHITE);
                }
        });
        itemID.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public
            void insertUpdate(DocumentEvent e) {
                checkInt();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void removeUpdate(DocumentEvent e) {
                checkInt();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void changedUpdate(DocumentEvent e) {
                checkInt();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            public void checkInt()
                {
                    try{
                        Integer.parseInt(itemID.getText());
                        itemID.setBackground(Color.WHITE);
                    }
                    catch(Exception error)
                    {
                        itemID.setBackground(errorColor);
                    }
                    finally
                    {
                        if(itemID.getText().length()==0)
                            itemID.setBackground(Color.WHITE);
                    }
                }
        });
        itemCost.getDocument().addDocumentListener(new DocumentListener(){
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
                    Matcher matcher = pattern.matcher(itemCost.getText());
                    if(matcher.matches() || itemCost.getText().length()==0)
                        itemCost.setBackground(Color.WHITE);
                    else
                        itemCost.setBackground(errorColor);
                }
        });
        itemActive.setSelected(true);
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
        itemName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        itemCost = new javax.swing.JTextField();
        itemAdd = new javax.swing.JButton();
        itemActive = new javax.swing.JCheckBox();
        itemReset = new javax.swing.JButton();
        itemClose = new javax.swing.JButton();
        itemID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Item Name");

        itemName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Item Cost");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        itemCost.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        itemAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        itemAdd.setText("Add Item");
        itemAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemAddMousePressed(evt);
            }
        });

        itemActive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        itemActive.setText("Active");
        itemActive.setDoubleBuffered(true);

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

        itemID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        itemID.setDoubleBuffered(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Item ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 523, Short.MAX_VALUE)
                .addComponent(itemClose))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(itemActive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(itemAdd)
                        .addGap(77, 77, 77)
                        .addComponent(itemReset)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(itemCost)
                            .addComponent(itemID)
                            .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(113, 113, 113))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(itemClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(itemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(itemCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(itemActive)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemAdd)
                    .addComponent(itemReset))
                .addGap(83, 83, 83))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void itemAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemAddMousePressed
        // TODO add your handling code here:
        if(itemID.getText().length()==0 || itemName.getText().length()==0 || itemCost.getText().length()==0 || 
                itemID.getBackground()==errorColor || itemName.getBackground()==errorColor || itemCost.getBackground()==errorColor)
//            JOptionPane.showMessageDialog(null, "Invalid details!");
        {
            JLabel message = new JLabel();
            message.setText("Invalid details!");
            message.setFont(new Font("Tahoma", 0, 18));
            JOptionPane.showMessageDialog(null, message);
        }
        else
        {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            String addResult = SqlQueries.addItem(Integer.parseInt(itemID.getText()), itemName.getText(), Float.parseFloat(itemCost.getText()), itemActive.isSelected());
            this.setCursor(Cursor.getDefaultCursor());
            if(addResult.equals(Boolean.toString(true))) {
                JLabel message = new JLabel("Item added successfully!");
                message.setFont(new Font("Tahoma", 0, 18));
                JOptionPane.showMessageDialog(null, message);
                itemResetMousePressed(null);
            }
            else
            {
                JLabel message = new JLabel(addResult);
                message.setFont(new Font("Tahoma", 0, 18));
                JOptionPane.showMessageDialog(null, message);
            }
        }
    }//GEN-LAST:event_itemAddMousePressed

    private void itemResetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemResetMousePressed
        // TODO add your handling code here:
        itemID.setBackground(Color.WHITE);
        itemName.setBackground(Color.WHITE);
        itemCost.setBackground(Color.WHITE);
        itemID.setText("");
        itemName.setText("");
        itemCost.setText("");
    }//GEN-LAST:event_itemResetMousePressed

    private void itemCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemCloseMousePressed
        // TODO add your handling code here:
        JDialog dialog = (JDialog) this.getRootPane().getParent();
        dialog.getParent().setEnabled(true);
        dialog.dispose();
    }//GEN-LAST:event_itemCloseMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox itemActive;
    private javax.swing.JButton itemAdd;
    private javax.swing.JButton itemClose;
    private javax.swing.JTextField itemCost;
    private javax.swing.JTextField itemID;
    private javax.swing.JTextField itemName;
    private javax.swing.JButton itemReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
