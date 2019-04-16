package InventApp.ViewControllers;

import java.awt.HeadlessException;
import java.awt.Image;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jerry
 */
public class POSViewController extends javax.swing.JFrame {

    /**
     * Creates new form MANAGE_ORDERS_FORM
     */
    public POSViewController() {
        initComponents();
        
        BindCombo();
        
        populateCustomerJtable();
        
        jComboBox_CATEGORIES_ActionPerformed(null);
        
        InventApp.Venta ord = new InventApp.Venta();
        
        // display the new order id in textfield
        try{
            jTextField_ORDER_ID.setText(String.valueOf(ord.getMaxOrderId() + 1));
        }catch(Exception ex){
            jTextField_ORDER_ID.setText(String.valueOf(1));
        }
        
        
    }
    
    
    // populate the categories combobox
    public void BindCombo(){

        InventApp.Category category = new InventApp.Category();

        TreeMap<String, Integer> map = category.populateCombo();

        for(String s : map.keySet()){
            jComboBox_CATEGORIES_.addItem(s);
        }
        
        
    }

    
    // populate the customers jtable
    public void populateCustomerJtable(){
        
        InventApp.Customer customer = new InventApp.Customer();
        ArrayList<InventApp.Customer> CustomerList = customer.customersList();
        
        String[] colNames = {"RFC","Nombre","Apellido","Telefono","Email"};
        Object[][] rows = new Object[CustomerList.size()][5];
        DefaultTableModel model = (DefaultTableModel) jTable_CUSTOMERS_.getModel();
        
        for(int i = 0; i < CustomerList.size(); i++){
            rows[i][0] = CustomerList.get(i).getId();
            rows[i][1] = CustomerList.get(i).getFirst_name();
            rows[i][2] = CustomerList.get(i).getLast_name();
            rows[i][3] = CustomerList.get(i).getTel();
            rows[i][4] = CustomerList.get(i).getEmail();
        }
        
        model.setDataVector(rows, colNames);

        jTable_CUSTOMERS_.setModel(model);
        jTable_CUSTOMERS_.setRowHeight(20);
    }
    
    
    // populate the products jtable by selected category from combobox
    public void populateProductJtable(Integer categoryId){
        
        InventApp.Product prd = new InventApp.Product();
        ArrayList<InventApp.Product> ProductList;
        if(categoryId != 9999)
            ProductList = prd.productsInCategoryList(categoryId);
        else
            ProductList = prd.getAllProducts();
        
        String[] colNames = {"Id","Name","Price","Quantity","Image","Description"};
        Object[][] rows = new Object[ProductList.size()][7];
        
        for(int i = 0; i < ProductList.size(); i++){
            rows[i][0] = ProductList.get(i).getId();
            rows[i][1] = ProductList.get(i).getName();
            rows[i][2] = ProductList.get(i).getPrice();
            rows[i][3] = ProductList.get(i).getQuantity();
            rows[i][4] = null;
            rows[i][5] = ProductList.get(i).getDescription();
        }
        
        InventApp.MyTableModel mmd = new InventApp.MyTableModel(rows, colNames);
        jTable_PRODUCTS_.setModel(mmd);
        jTable_PRODUCTS_.setRowHeight(20);
        jTable_PRODUCTS_.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable_PRODUCTS_.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTable_PRODUCTS_.getColumnModel().getColumn(4).setPreferredWidth(120);
    }
    
    public void populateProductJtableWithFilter(Integer categoryId, String filter){
        
        InventApp.Product prd = new InventApp.Product();
        ArrayList<InventApp.Product> ProductList;
        ArrayList<InventApp.Product> TempProductList;
        if(categoryId != 9999)
            TempProductList = prd.productsInCategoryList(categoryId);
        else
            TempProductList = prd.getAllProducts();
        
        ProductList = new ArrayList<InventApp.Product>();
        for(InventApp.Product p : TempProductList){
            if(p.containsSignificantSubstr(filter)){
                ProductList.add(p);
            }
        }
        
        String[] colNames = {"Id","Name","Price","Quantity","Image","Description"};
        Object[][] rows = new Object[ProductList.size()][7];
        
        for(int i = 0; i < ProductList.size(); i++){
            rows[i][0] = ProductList.get(i).getId();
            rows[i][1] = ProductList.get(i).getName();
            rows[i][2] = ProductList.get(i).getPrice();
            rows[i][3] = ProductList.get(i).getQuantity();
            rows[i][4] = null;
            rows[i][5] = ProductList.get(i).getDescription();
        }
        
        InventApp.MyTableModel mmd = new InventApp.MyTableModel(rows, colNames);
        jTable_PRODUCTS_.setModel(mmd);
        jTable_PRODUCTS_.setRowHeight(20);
        jTable_PRODUCTS_.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable_PRODUCTS_.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTable_PRODUCTS_.getColumnModel().getColumn(4).setPreferredWidth(120);
    }
    
    // get total amount of the product added to the order table
    // and display the value into jlabel
    public void getTotal()
    {
        double total = 0;
        for(int i = 0; i < jTable_PRODUCTS_IN_ORDER_.getModel().getRowCount(); i++)
               {
                   total = total + Double.valueOf(jTable_PRODUCTS_IN_ORDER_.getValueAt(i, 4).toString());
               }
        jLabel_TOTAL.setText("Total: " + String.valueOf(total));
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_CUSTOMERS_ = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField_CUSTOMER_ID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_ORDER_ID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_PRODUCTS_ = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_PRODUCTS_IN_ORDER_ = new javax.swing.JTable();
        jComboBox_CATEGORIES_ = new javax.swing.JComboBox<>();
        jButton_INSERT_ORDER_ = new javax.swing.JButton();
        jButton_SHOW_ORDERS_ = new javax.swing.JButton();
        jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEè = new javax.swing.JButton();
        jButton_CLEAR_ORDER_TABLE_ = new javax.swing.JButton();
        jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_ = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel_TOTAL = new javax.swing.JLabel();
        jTextField_QUERY = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(34, 49, 63));

        jTable_CUSTOMERS_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_CUSTOMERS_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CUSTOMERS_MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_CUSTOMERS_);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Venta numero:");

        jTextField_CUSTOMER_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_CUSTOMER_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CUSTOMER_IDKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("RFC: ");

        jTextField_ORDER_ID.setEditable(false);
        jTextField_ORDER_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha facturacion:");
        jLabel3.setToolTipText("");

        jTable_PRODUCTS_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable_PRODUCTS_);

        jTable_PRODUCTS_IN_ORDER_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Price", "Quantity", "Quantity X Price"
            }
        ));
        jScrollPane3.setViewportView(jTable_PRODUCTS_IN_ORDER_);

        jComboBox_CATEGORIES_.setBackground(new java.awt.Color(111, 78, 55));
        jComboBox_CATEGORIES_.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox_CATEGORIES_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_CATEGORIES_ActionPerformed(evt);
            }
        });

        jButton_INSERT_ORDER_.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_INSERT_ORDER_.setText("Checkout");
        jButton_INSERT_ORDER_.setToolTipText("");
        jButton_INSERT_ORDER_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_INSERT_ORDER_ActionPerformed(evt);
            }
        });

        jButton_SHOW_ORDERS_.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_SHOW_ORDERS_.setText("Listar compras");
        jButton_SHOW_ORDERS_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SHOW_ORDERS_ActionPerformed(evt);
            }
        });

        jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEè.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEè.setText("Quitar producto");
        jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEè.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEèActionPerformed(evt);
            }
        });

        jButton_CLEAR_ORDER_TABLE_.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_CLEAR_ORDER_TABLE_.setText("Limpiar");
        jButton_CLEAR_ORDER_TABLE_.setToolTipText("");
        jButton_CLEAR_ORDER_TABLE_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CLEAR_ORDER_TABLE_ActionPerformed(evt);
            }
        });

        jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_.setText(">>>");
        jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_TOTAL.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel_TOTAL.setText("Total: 0.0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 52, Short.MAX_VALUE)
                .addComponent(jLabel_TOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_TOTAL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jTextField_QUERY.setToolTipText("Nombre de producto");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_CATEGORIES_, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField_QUERY, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_ORDER_ID, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField_CUSTOMER_ID, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_SHOW_ORDERS_, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEè, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_CLEAR_ORDER_TABLE_, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_INSERT_ORDER_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_CATEGORIES_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_QUERY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_CUSTOMER_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_ORDER_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_SHOW_ORDERS_)
                            .addComponent(jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEè)
                            .addComponent(jButton_CLEAR_ORDER_TABLE_))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 207, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_INSERT_ORDER_))
                        .addGap(3, 3, 3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jLabel4.getAccessibleContext().setAccessibleName("CUSTOMER:");
        jLabel4.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String substr = jTextField_QUERY.getText();
        InventApp.Category category = new InventApp.Category();
        TreeMap<String, Integer> map = category.populateCombo();
        populateProductJtableWithFilter(Integer.valueOf(map.get(jComboBox_CATEGORIES_.getSelectedItem().toString()).toString()), substr);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // add product from table products to order table
    private void jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_ActionPerformed

        Integer quantity ;
        int rowindex;

        try{

            // get the quantity from InputDialog
            quantity = Integer.valueOf(JOptionPane.showInputDialog("Enter The Quantity You Want","1"));

            rowindex = jTable_PRODUCTS_.getSelectedRow();

            boolean isExist = false;// a variable to check if the product already exist in the table order
            int index = 0;

            Object rowData[] = new Object[5];

            rowData[0] = jTable_PRODUCTS_.getValueAt(rowindex, 0);
            rowData[1] = jTable_PRODUCTS_.getValueAt(rowindex, 1);
            rowData[2] = jTable_PRODUCTS_.getValueAt(rowindex, 2);
            rowData[3] = quantity;

            Double price = Double.valueOf(jTable_PRODUCTS_.getValueAt(rowindex, 2).toString());

            rowData[4] = quantity * price;

            DefaultTableModel model = (DefaultTableModel)jTable_PRODUCTS_IN_ORDER_.getModel();

            // if the quantity you entred is heigher than the one in the jtable products
            if(quantity > Integer.valueOf(jTable_PRODUCTS_.getValueAt(rowindex, 3).toString()))
            {
                JOptionPane.showMessageDialog(null, "Unavailable Quantity","Invalid Value",2);
            }
            // if the quantity you entred is 0
            else if(quantity == 0)
            {
                JOptionPane.showMessageDialog(null, "Quantity Can't Be 0","Invalid Value",2);
            }
            else
            {
                if(jTable_PRODUCTS_IN_ORDER_.getModel().getRowCount() == 0)
                {

                    model.addRow(rowData);
                    getTotal();
                }
                else
                {
                    // check if the product you want to add already exisit in the table ( using the product id )
                    for(int i = 0; i < jTable_PRODUCTS_IN_ORDER_.getModel().getRowCount(); i++)
                    {
                        if(rowData[0] == jTable_PRODUCTS_IN_ORDER_.getValueAt(i, 0))
                        {
                            isExist = true;
                            index = i;
                        }
                    }
                    if(isExist)
                    {
                        // if the product already exisit
                        // claculate the new quantity
                        // new quantity = quantity(the current quantity you entred) + ( the quantity in the jtable order )
                        Integer newQuantity = quantity + Integer.valueOf(jTable_PRODUCTS_IN_ORDER_.getValueAt(index, 3).toString());

                        // if the new quantity is heigher than the one in the jtable products
                        if(newQuantity > Integer.valueOf(jTable_PRODUCTS_.getValueAt(rowindex, 3).toString()))
                        {
                            JOptionPane.showMessageDialog(null, "Unavailable Quantity","Invalid Value",2);
                        }else{
                            jTable_PRODUCTS_IN_ORDER_.setValueAt(newQuantity, index, 3);
                            jTable_PRODUCTS_IN_ORDER_.setValueAt(newQuantity * price, index, 4);
                            getTotal();
                        }
                    }
                    else{
                        model.addRow(rowData);
                        getTotal();
                    }

                }

            }

        }catch(HeadlessException | NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 1);
        }
    }//GEN-LAST:event_jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_ActionPerformed

    // remove all products from the order jtable
    private void jButton_CLEAR_ORDER_TABLE_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CLEAR_ORDER_TABLE_ActionPerformed

        DefaultTableModel model = (DefaultTableModel) jTable_PRODUCTS_IN_ORDER_.getModel();
        model.setRowCount(0);
        getTotal();
    }//GEN-LAST:event_jButton_CLEAR_ORDER_TABLE_ActionPerformed

    // remove selected product from jtable order
    private void jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEèActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEèActionPerformed

        try{
            Integer selectedRowIndex = jTable_PRODUCTS_IN_ORDER_.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel)jTable_PRODUCTS_IN_ORDER_.getModel();
            model.removeRow(selectedRowIndex);
            getTotal();
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Select A Product From The Order Table", "No Product Selected", 1);
        }
    }//GEN-LAST:event_jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEèActionPerformed

    // show all orders in a new jframe
    private void jButton_SHOW_ORDERS_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SHOW_ORDERS_ActionPerformed

        SaleListingViewController allOrdersForm = new SaleListingViewController();
        allOrdersForm.pack();
        allOrdersForm.setVisible(true);
        allOrdersForm.setLocationRelativeTo(null);
        allOrdersForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton_SHOW_ORDERS_ActionPerformed

    // insert order
    private void jButton_INSERT_ORDER_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_INSERT_ORDER_ActionPerformed

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String orderDate = "";

        if(jDateChooser1.getDate() != null){
            orderDate = dateFormat.format(jDateChooser1.getDate());

        } else{
            Date date = new Date();
            orderDate = dateFormat.format(date);
        }

        if(jTextField_CUSTOMER_ID.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Select A Customer To Add The Order", "No Customer Selected", 1);
        }

        else if(jTable_PRODUCTS_IN_ORDER_.getRowCount() > 0)
        {

            Integer productId;
            Integer orderId = Integer.valueOf(jTextField_ORDER_ID.getText());
            Integer qty;
            String price;
            String total;

            // insert the order
            InventApp.Venta.insertOrder(orderId, orderDate, Integer.valueOf(jTextField_CUSTOMER_ID.getText()));

            // get the product data
            for(int i = 0; i < jTable_PRODUCTS_IN_ORDER_.getRowCount(); i++)
            {
                productId = Integer.valueOf(jTable_PRODUCTS_IN_ORDER_.getValueAt(i, 0).toString());
                price = jTable_PRODUCTS_IN_ORDER_.getValueAt(i, 2).toString();
                qty = Integer.valueOf(jTable_PRODUCTS_IN_ORDER_.getValueAt(i, 3).toString());
                total = jTable_PRODUCTS_IN_ORDER_.getValueAt(i, 4).toString();

                // insert the order details
                InventApp.Venta.insertOrderDetails(productId, orderId, qty, price, total);

                // display the new order id in textfield
                InventApp.Venta ord = new InventApp.Venta();
                jTextField_ORDER_ID.setText(String.valueOf(ord.getMaxOrderId() + 1));
            }

            jComboBox_CATEGORIES_ActionPerformed(null);

        }
        else{

            JOptionPane.showMessageDialog(null, "You Must Add At Least 1 Product To The Order", "No Product Added", 1);

        }
    }//GEN-LAST:event_jButton_INSERT_ORDER_ActionPerformed

    // display products by category
    private void jComboBox_CATEGORIES_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_CATEGORIES_ActionPerformed

        InventApp.Category category = new InventApp.Category();
        TreeMap<String, Integer> map = category.populateCombo();
        populateProductJtable(Integer.valueOf(map.get(jComboBox_CATEGORIES_.getSelectedItem().toString()).toString()));
    }//GEN-LAST:event_jComboBox_CATEGORIES_ActionPerformed

    // allow only integer
    private void jTextField_CUSTOMER_IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CUSTOMER_IDKeyTyped

        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_CUSTOMER_IDKeyTyped

    // get customer id on jtable mouse clicked
    private void jTable_CUSTOMERS_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CUSTOMERS_MouseClicked

        Integer selectedRowIndex = jTable_CUSTOMERS_.getSelectedRow();
        jTextField_CUSTOMER_ID.setText(jTable_CUSTOMERS_.getValueAt(selectedRowIndex, 0).toString());
    }//GEN-LAST:event_jTable_CUSTOMERS_MouseClicked

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(POSViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POSViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POSViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POSViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POSViewController().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_CLEAR_ORDER_TABLE_;
    private javax.swing.JButton jButton_INSERT_ORDER_;
    private javax.swing.JButton jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEè;
    private javax.swing.JButton jButton_SHOW_ORDERS_;
    private javax.swing.JButton jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_;
    private javax.swing.JComboBox<String> jComboBox_CATEGORIES_;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_TOTAL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_CUSTOMERS_;
    private javax.swing.JTable jTable_PRODUCTS_;
    private javax.swing.JTable jTable_PRODUCTS_IN_ORDER_;
    private javax.swing.JTextField jTextField_CUSTOMER_ID;
    private javax.swing.JTextField jTextField_ORDER_ID;
    private javax.swing.JTextField jTextField_QUERY;
    // End of variables declaration//GEN-END:variables
}
