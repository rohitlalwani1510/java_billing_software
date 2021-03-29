/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericbillingsoftware;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        class AddBill extends javax.swing.JPanel {
    public void setStaff(String name,String email)
    {
        staffName.setText(name);
        staffEmail.setText(email);
    }
    public JTable getTable()
    {
        return jTable1;
    }
    public void updateTotal()
    {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Vector dataVector = model.getDataVector();
        float sum = 0;
        for(Object cur_vector:dataVector)
        {
            Vector cur = (Vector) cur_vector;
            sum+=(Float)cur.get(4);
        }
        itemCount.setText(Integer.toString(dataVector.size()));
        totalCost.setText(Float.toString(sum));
        paidAmount.setText("");
        paidAmount.setBackground(Color.WHITE);
        changeAmount.setText("");
    }
    public boolean existingCustomer = true;
    public Color errorColor;
    public
            AddBill() {
                errorColor = new Color(255, 186, 186);
        initComponents();
        updateTotal();
        customerPhone.getDocument().addDocumentListener(new DocumentListener(){
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
                        Matcher m = p.matcher(customerPhone.getText());
                        if(!customerName.getText().equals("") && !m.matches())
                        {
                            customerPhone.setBackground(errorColor);
                            customerName.setEnabled(false);
                            customerEmail.setEnabled(false);
                        }
                        else
                        {
                            customerPhone.setBackground(Color.WHITE);
                            String[] customer = SqlQueries.getCustomer(customerPhone.getText());
                            customerName.setEnabled(true);
                            customerEmail.setEnabled(true);
                            if(customer!=null)
                            {
                                customerName.setEditable(false);
                                customerName.setText(customer[0]);
                                customerName.setBackground(Color.WHITE);
                                customerEmail.setEditable(false);
                                customerEmail.setText(customer[1]);
                                customerEmail.setBackground(Color.WHITE);
                            }
                            else
                            {
                                customerName.setEditable(true);
                                customerEmail.setEditable(true);
                            }
                        }
                    }
                });
        customerName.getDocument().addDocumentListener(new DocumentListener(){
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
                        String regex = "^[a-zA-Z][a-zA-Z ]*[a-zA-Z]$";
                        Pattern p = Pattern.compile(regex);
                        Matcher m = p.matcher(customerName.getText());
                        if(!customerName.getText().equals("") && !m.matches())
                            customerName.setBackground(errorColor);
                        else
                            customerName.setBackground(Color.WHITE);
                    }
                });
        customerEmail.getDocument().addDocumentListener(new DocumentListener(){
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
                    public void change(){
                        String regex = "^[a-zA-Z0-9]+[a-zA-Z0-9.]*[a-zA-Z0-9.]+@[a-zA-Z0-9]+.[a-zA-Z]+";
                        Pattern p = Pattern.compile(regex);
                        Matcher m = p.matcher(customerEmail.getText());
                        if(!customerEmail.getText().equals("") && !m.matches())
                            customerEmail.setBackground(errorColor);
                        else
                            customerEmail.setBackground(Color.WHITE);
                    }
                });
        paidAmount.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public
            void insertUpdate(DocumentEvent e) {
                change();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void removeUpdate(DocumentEvent e) {
                change();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void changedUpdate(DocumentEvent e) {
                change();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            public void change()
                {
                    String paid = paidAmount.getText();
                    if(paid.length()<=0)
                {
                    paidAmount.setBackground(Color.WHITE);
                    changeAmount.setText("");
                    return;
                }
                    if(paid.charAt(paid.length()-1)>='0' && paid.charAt(paid.length()-1)<='9')
                {
                    try
                {
                    float paidF = Float.parseFloat(paid);
                    if(paidF<0 || paidF<Float.parseFloat(totalCost.getText()))
                {
                    throw new Exception();
                }
                    else
                {
                    paidAmount.setBackground(Color.WHITE);
                    float change = paidF - Float.parseFloat(totalCost.getText());
                    changeAmount.setText(Float.toString(change));
                }
                }
                    catch(Exception error)
                {
                    paidAmount.setBackground(errorColor);
                    changeAmount.setText("0");
                }
                }
                    else
                {
                    paidAmount.setBackground(errorColor);
                    changeAmount.setText("0");
                }
                }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        staffName = new javax.swing.JLabel();
        staffEmail = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        customerPhone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        customerName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        customerEmail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        itemCount = new javax.swing.JLabel();
        totalCost = new javax.swing.JLabel();
        changeAmount = new javax.swing.JLabel();
        paidAmount = new javax.swing.JTextField();
        addBillClose = new javax.swing.JButton();
        printBill = new javax.swing.JButton();
        resetBill = new javax.swing.JButton();
        addItem = new javax.swing.JButton();
        editItem = new javax.swing.JButton();
        removeItem = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Item Cost", "Item Quantity", "Total Item Cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Staff Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Staff Email:");

        staffName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        staffEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(staffEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staffName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staffName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staffEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Customer Phone");

        customerPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Customer Name");

        customerName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        customerName.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Customer Email");

        customerEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customerEmail.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(customerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(customerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Unique Items:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Total Cost:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Paid Amount:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Change Amount:");

        itemCount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        itemCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        totalCost.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalCost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        changeAmount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        changeAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        paidAmount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        paidAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        paidAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidAmountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemCount, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(totalCost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changeAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paidAmount))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemCount, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(totalCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paidAmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(changeAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );

        addBillClose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addBillClose.setText("Close");
        addBillClose.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addBillClose.setDoubleBuffered(true);
        addBillClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addBillCloseMousePressed(evt);
            }
        });

        printBill.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printBill.setText("Print Bill");
        printBill.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        printBill.setDoubleBuffered(true);
        printBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                printBillMousePressed(evt);
            }
        });

        resetBill.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        resetBill.setText("Reset");
        resetBill.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        resetBill.setDoubleBuffered(true);
        resetBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                resetBillMousePressed(evt);
            }
        });

        addItem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addItem.setText("Add Item");
        addItem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addItem.setDoubleBuffered(true);
        addItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addItemMousePressed(evt);
            }
        });

        editItem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        editItem.setText("Edit Item");
        editItem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        editItem.setDoubleBuffered(true);
        editItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editItemMousePressed(evt);
            }
        });

        removeItem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        removeItem.setText("Remove Item");
        removeItem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        removeItem.setDoubleBuffered(true);
        removeItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                removeItemMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(addItem)
                .addGap(18, 18, 18)
                .addComponent(editItem)
                .addGap(18, 18, 18)
                .addComponent(removeItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(printBill)
                .addGap(18, 18, 18)
                .addComponent(resetBill)
                .addGap(18, 18, 18)
                .addComponent(addBillClose)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printBill, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBill, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBillClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBillCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBillCloseMousePressed
        // TODO add your handling code here:
        JLabel message = new JLabel("Are you sure you want to exit?");
        message.setFont(new Font("Tahoma", 0, 18));
        int result = JOptionPane.showConfirmDialog(null, message, "Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result==JOptionPane.YES_OPTION)   
        {
            JDialog dialog = (JDialog) this.getRootPane().getParent();
            dialog.getParent().setEnabled(true);
            dialog.dispose();
        }
    }//GEN-LAST:event_addBillCloseMousePressed

    private void printBillMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printBillMousePressed
        // TODO add your handling code here:
        JLabel message = new JLabel();
        message.setFont(new Font("Tahoma",0,18));
        if(Integer.parseInt(itemCount.getText())==0 || customerPhone.getText().length()==0 ||
           customerPhone.getBackground()==errorColor || customerName.getText().length()==0 || customerName.getBackground()==errorColor ||
           customerEmail.getBackground()==errorColor ||
           paidAmount.getText().length()==0 || paidAmount.getBackground()==errorColor)
        {
            message.setText("Invalid details or no item in bill");
            JOptionPane.showMessageDialog(null, message);
            return;
        }
        String cur_bill_id = SqlQueries.getNextBillId();
        System.out.println(cur_bill_id);
        String location = "C:\\Users\\rohit\\Desktop\\java_billing_project\\"+cur_bill_id+".pdf";
        String sql_location = "C:\\\\Users\\\\rohit\\\\Desktop\\\\java_billing_project\\\\"+cur_bill_id+".pdf";
        System.out.println(location);
        try{
            Document doc = new Document();
            String add_bill_result = SqlQueries.addBill(cur_bill_id, sql_location);
            if(!add_bill_result.equals("true"))
                throw new Exception(add_bill_result);
            PdfWriter pdfWriter = PdfWriter.getInstance(doc,new FileOutputStream(location));
            doc.open();
            
            Paragraph header = new Paragraph("Java Billing Software\n\n");
            header.getFont().setSize(24);
            header.setAlignment(Element.ALIGN_CENTER);
            doc.add(header);
            
            Paragraph bill_id = new Paragraph("Bill ID: " + cur_bill_id);
            bill_id.setAlignment(Element.ALIGN_RIGHT);
            doc.add(bill_id);
            
            Paragraph staff_name, staff_email;
            staff_name = (new Paragraph("Staff Name: " + staffName.getText().toUpperCase()));
            staff_email = (new Paragraph("Staff Email: " + staffEmail.getText().toUpperCase() + "\n\n"));
            staff_name.setAlignment(Element.ALIGN_CENTER);
            staff_email.setAlignment(Element.ALIGN_CENTER);
            doc.add(staff_name);
            doc.add(staff_email);
            
            Paragraph customer_name, customer_phone;
            customer_name = (new Paragraph("Customer Name: " + customerName.getText().toUpperCase()));
            customer_phone = (new Paragraph("Customer Phone: " + customerPhone.getText().toUpperCase()));
            customer_name.setAlignment(Element.ALIGN_CENTER);
            customer_phone.setAlignment(Element.ALIGN_CENTER);
            doc.add(customer_name);
            doc.add(customer_phone);
            if(!customerEmail.getText().equals(""))
            {
                Paragraph customer_email = (new Paragraph("Customer Email: " + customerEmail.getText().toUpperCase()));
                customer_email.setAlignment(Element.ALIGN_CENTER);
                doc.add(customer_email);
            }
            doc.add(new Paragraph("\n\n"));
            
            PdfPTable pdfTable = new PdfPTable(5);
            // adding headers
            pdfTable.addCell("Item ID");
            pdfTable.addCell("Item Name");
            pdfTable.addCell("Cost per Item");
            pdfTable.addCell("Item Quantity");
            pdfTable.addCell("Total Item Cost");
            // adding table data
            for(int i=0;i<jTable1.getRowCount();++i)
            {
                String id,name,cost_per_item,item_quantity,total_item_cost;
                id = jTable1.getValueAt(i, 0).toString();
                name = jTable1.getValueAt(i, 1).toString();
                cost_per_item = jTable1.getValueAt(i, 2).toString();
                item_quantity = jTable1.getValueAt(i, 3).toString();
                total_item_cost = jTable1.getValueAt(i, 4).toString();
                pdfTable.addCell(id);
                pdfTable.addCell(name);
                pdfTable.addCell(cost_per_item);
                pdfTable.addCell(item_quantity);
                pdfTable.addCell(total_item_cost);
            }
            
            doc.add(pdfTable);
            
            Paragraph total_cost,paid_amount,change_amount;
            total_cost = (new Paragraph("\nTotal Bill: " + totalCost.getText()));
            paid_amount = (new Paragraph("Amount Paid: " + paidAmount.getText()));
            change_amount = (new Paragraph("Change Amount: " + changeAmount.getText() + "\n\n"));
            total_cost.setAlignment(Element.ALIGN_CENTER);
            paid_amount.setAlignment(Element.ALIGN_CENTER);
            change_amount.setAlignment(Element.ALIGN_CENTER);
            doc.add(total_cost);
            doc.add(paid_amount);
            doc.add(change_amount);
            
            Paragraph footer = (new Paragraph("\n\nThank you and visit again!"));
            footer.setAlignment(Element.ALIGN_CENTER);
            doc.add(footer);
            
            doc.close();
            pdfWriter.close();
            
            SqlQueries.addCustomer(customerName.getText(), customerPhone.getText(), customerEmail.getText());
            message.setText("Bill printed and saved to Desktop successfully!");
            JOptionPane.showMessageDialog(null, message);
            JDialog dialog = (JDialog) this.getRootPane().getParent();
            dialog.getParent().setEnabled(true);
            dialog.dispose();
        }
        catch(Exception error)
        {
            SqlQueries.deleteBill(cur_bill_id);
            message.setText(error.getMessage());
            JOptionPane.showMessageDialog(null, message);
        }
    }//GEN-LAST:event_printBillMousePressed

    private void resetBillMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetBillMousePressed
        // TODO add your handling code here:
        JLabel message = new JLabel("Are you sure?");
        message.setFont(new Font("Tahoma",0,18));
        int confirm = JOptionPane.showConfirmDialog(null, message, "Reset?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(confirm==JOptionPane.YES_OPTION)
        {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            customerPhone.setText("");
            customerName.setText("");
            customerEmail.setText("");
            customerName.setEnabled(false);
            customerEmail.setEnabled(false);
            paidAmount.setText("");
            itemCount.setText("");
            totalCost.setText("");
            changeAmount.setText("");
            paidAmount.setBackground(Color.WHITE);
            customerPhone.setBackground(Color.WHITE);
            customerName.setBackground(Color.WHITE);
            customerEmail.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_resetBillMousePressed

    private void addItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItemMousePressed
        // TODO add your handling code here:
        AddItemBill addItemBillPanel = new AddItemBill();
        addItemBillPanel.setBill(this);
        JDialog dialog = new JDialog((Dialog) this.getRootPane().getParent());
        dialog.getContentPane().add(addItemBillPanel);
        dialog.pack();
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);
        dialog.addWindowListener(new WindowListener(){
            @Override
            public
            void windowOpened(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void windowClosing(WindowEvent e) {
                dialog.getParent().setEnabled(true);
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void windowClosed(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void windowIconified(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void windowDeiconified(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void windowActivated(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public
            void windowDeactivated(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }//GEN-LAST:event_addItemMousePressed

    private void editItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editItemMousePressed
        // TODO add your handling code here:
        JLabel message = new JLabel("Select exactly one item!");
        message.setFont(new Font("Tahoma",0,18));
        if(jTable1.getSelectedRowCount()==1)
        {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int cur_row = jTable1.getSelectedRow();
            String cost_per_item,quantity;
            cost_per_item = Float.toString((float) model.getValueAt(cur_row, 2));
            quantity = Integer.toString((int) model.getValueAt(cur_row, 3));
            this.setEnabled(false);
            EditItemBill editItemBillPanel = new EditItemBill();
            editItemBillPanel.setBill(this);
            JDialog dialog = new JDialog((Dialog) this.getRootPane().getParent());
            dialog.getContentPane().add(editItemBillPanel);
            dialog.pack();
            editItemBillPanel.setCostPerItem(cost_per_item);
            editItemBillPanel.setQuantity(quantity);
            dialog.setVisible(true);
            dialog.setLocationRelativeTo(this);
            dialog.setResizable(false);
            dialog.addWindowListener(new WindowListener(){
                @Override
                public
                void windowOpened(WindowEvent e) {
    //                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public
                void windowClosing(WindowEvent e) {
                    dialog.getParent().setEnabled(true);
    //                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public
                void windowClosed(WindowEvent e) {
    //                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public
                void windowIconified(WindowEvent e) {
    //                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public
                void windowDeiconified(WindowEvent e) {
    //                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public
                void windowActivated(WindowEvent e) {
    //                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public
                void windowDeactivated(WindowEvent e) {
    //                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
        }
        else
            JOptionPane.showMessageDialog(null, message);
    }//GEN-LAST:event_editItemMousePressed

    private void removeItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeItemMousePressed
        // TODO add your handling code here:
        JLabel message = new JLabel("Select exactly one item!");
        message.setFont(new Font("Tahoma",0,18));
        if(jTable1.getSelectedRowCount()==1)
        {
            int row_index = jTable1.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(row_index);
            updateTotal();
        }
        else
            JOptionPane.showMessageDialog(null, message);
    }//GEN-LAST:event_removeItemMousePressed

    private void paidAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paidAmountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBillClose;
    private javax.swing.JButton addItem;
    private javax.swing.JLabel changeAmount;
    private javax.swing.JTextField customerEmail;
    private javax.swing.JTextField customerName;
    private javax.swing.JTextField customerPhone;
    private javax.swing.JButton editItem;
    private javax.swing.JLabel itemCount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField paidAmount;
    private javax.swing.JButton printBill;
    private javax.swing.JButton removeItem;
    private javax.swing.JButton resetBill;
    private javax.swing.JLabel staffEmail;
    private javax.swing.JLabel staffName;
    private javax.swing.JLabel totalCost;
    // End of variables declaration//GEN-END:variables
}
