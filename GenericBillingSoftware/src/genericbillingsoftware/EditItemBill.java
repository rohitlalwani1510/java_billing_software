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
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rohit
 */
public
        class EditItemBill extends javax.swing.JPanel {

    /**
     * Creates new form EditItemBill
     */
    AddBill bill;
    public void setBill(AddBill bill)
    {
        this.bill = bill;
    }
    public AddBill getBill()
    {
        return bill;
    }
    public void setCostPerItem(String costPerItem)
    {
        this.costPerItem.setText(costPerItem);
    }
    public void setQuantity(String quantity)
    {
        this.itemQuantity.setText(quantity);
    }
    public Color errorColor;
    public
            EditItemBill() {
                errorColor = new Color(255, 186, 186);
        initComponents();
        itemQuantity.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public
            void insertUpdate(DocumentEvent e) {
                check();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void removeUpdate(DocumentEvent e) {
                check();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void changedUpdate(DocumentEvent e) {
                check();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            public void check()
            {
                if(itemQuantity.getText().length()==0)
                {
                    itemQuantity.setBackground(Color.WHITE);
                    totalItemCost.setText("No quantity given");
                }
                else
                {
                    try{
                        Integer.parseInt(itemQuantity.getText());
                        itemQuantity.setBackground(Color.WHITE);
                        totalItemCost.setText(Float.toString(Integer.parseInt(itemQuantity.getText())*Float.parseFloat(costPerItem.getText())));
                    }
                    catch(Exception error)
                    {
                        itemQuantity.setBackground(errorColor);
                        totalItemCost.setText("Invalid quantity");
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

        itemClose = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        costPerItem = new javax.swing.JLabel();
        totalItemCost = new javax.swing.JLabel();
        itemQuantity = new javax.swing.JTextField();
        updateItemBill = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        itemClose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        itemClose.setText("Close");
        itemClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemCloseMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Cost Per Item:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Quantity:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Total Cost:");

        costPerItem.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        totalItemCost.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        itemQuantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        updateItemBill.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateItemBill.setText("Update Item");
        updateItemBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateItemBillMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(itemClose))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalItemCost, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(costPerItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(updateItemBill)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(itemClose)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(costPerItem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(itemQuantity)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(totalItemCost, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(updateItemBill)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateItemBillMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateItemBillMousePressed
        // TODO add your handling code here:
        if(itemQuantity.getText().length()==0 || itemQuantity.getBackground()==errorColor)
        {
            JLabel message = new JLabel("Invalid details");
            message.setFont(new Font("Tahoma",0,18));
            JOptionPane.showMessageDialog(null,message);
            return;
        }
        AddBill bill = getBill();
        JTable table = bill.getTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int cur_row = table.getSelectedRow();
        model.setValueAt(Integer.parseInt(itemQuantity.getText()),cur_row,3);
        model.setValueAt(Float.parseFloat(totalItemCost.getText()),cur_row,4);
        bill.updateTotal();
        itemCloseMousePressed(null);
    }//GEN-LAST:event_updateItemBillMousePressed

    private void itemCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemCloseMousePressed
        // TODO add your handling code here:
        JDialog dialog = (JDialog) this.getRootPane().getParent();
        dialog.getParent().setEnabled(true);
        dialog.dispose();
    }//GEN-LAST:event_itemCloseMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel costPerItem;
    private javax.swing.JButton itemClose;
    private javax.swing.JTextField itemQuantity;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel totalItemCost;
    private javax.swing.JButton updateItemBill;
    // End of variables declaration//GEN-END:variables
}
