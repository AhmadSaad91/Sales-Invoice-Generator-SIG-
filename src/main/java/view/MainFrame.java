package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class MainFrame extends JFrame implements ActionListener {
    private javax.swing.JButton createNewInvoiceBtn;
    private javax.swing.JButton deleteInvoiceBtn;
    private javax.swing.JButton createItemBtn;
    private javax.swing.JButton deleteItemBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel invoiceNumber;
    private javax.swing.JLabel invoiceTotal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem loadFileBtn;
    private javax.swing.JMenuItem saveFileBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JTable itemsTable;
    private javax.swing.JTextField date;
    private javax.swing.JTextField customerName;
    private static MainFrame frame=new MainFrame();
    private Controller controller=new Controller();

    private MainFrame() {
        super("Sales Invoice Generator (SIG)");

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        createNewInvoiceBtn = new javax.swing.JButton();
        deleteInvoiceBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        customerName = new javax.swing.JTextField();
        invoiceNumber = new javax.swing.JLabel();
        invoiceTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        createItemBtn = new javax.swing.JButton();
        deleteItemBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadFileBtn = new javax.swing.JMenuItem();
        saveFileBtn = new javax.swing.JMenuItem();

        jLabel1.setText("Invoices Table");

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "No.", "Date", "Customer", "Total"
                }
        ));

        invoicesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked();
            }
        });

        jScrollPane1.setViewportView(invoicesTable);

        createNewInvoiceBtn.setText("Create New Invoice");
        createNewInvoiceBtn.addActionListener(this);

        deleteInvoiceBtn.setText("Delete Invoice ");
        deleteInvoiceBtn.addActionListener(this);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(createNewInvoiceBtn)
                                .addGap(64, 64, 64)
                                .addComponent(deleteInvoiceBtn)
                                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(createNewInvoiceBtn)
                                        .addComponent(deleteInvoiceBtn))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Invoice Number");

        jLabel3.setText("Invoice Date");

        jLabel4.setText("Customer Name");

        jLabel5.setText("Invoice Total");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Invoice Items"));

        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "No.", "Item Name", "Item Price", "Count", "Item Total"
                }
        ));
        jScrollPane2.setViewportView(itemsTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        createItemBtn.setText("Create Item");
        createItemBtn.addActionListener(this);

        deleteItemBtn.setText("Delete Item");
        deleteItemBtn.addActionListener(this);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel5))
                                                .addGap(36, 36, 36)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(date)
                                                        .addComponent(customerName)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(invoiceTotal)
                                                                        .addComponent(invoiceNumber))
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addContainerGap())
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(createItemBtn)
                                .addGap(58, 58, 58)
                                .addComponent(deleteItemBtn)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(invoiceNumber))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(invoiceTotal))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(createItemBtn)
                                        .addComponent(deleteItemBtn))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        loadFileBtn.setText("Load File");
        loadFileBtn.addActionListener(this);
        jMenu1.add(loadFileBtn);

        saveFileBtn.setText("Save File");
        saveFileBtn.addActionListener(this);
        jMenu1.add(saveFileBtn);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );


        pack();
        setLocation(200,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
    public static MainFrame getInstance(){
        return frame;
    }

    public JTable getInvoicesTable() {
        return invoicesTable;
    }
    public JLabel getInvoiceNumber() {
        return invoiceNumber;
    }
    public JLabel getInvoiceTotal() {
        return invoiceTotal;
    }

    public JTable getItemsTable() {
        return itemsTable;
    }

    public JTextField getDate() {
        return date;
    }

    public JTextField getCustomerName() {
        return customerName;
    }

    public static void main(String[] args) {
        frame.setVisible(true);
        frame.controller.load(frame.getInvoicesTable());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(deleteInvoiceBtn)) {
            controller.deleteInvoice(invoicesTable, invoiceNumber,  date,  customerName
                    ,  invoiceTotal,  itemsTable);

        }else if(e.getSource().equals(deleteItemBtn)){
            controller.deleteItem(itemsTable,invoiceTotal);
            controller.displayInvoicesTable(invoicesTable);
        }else if(e.getSource().equals(loadFileBtn)){
            controller.load(invoicesTable);

        }else if(e.getSource().equals(saveFileBtn)){
                controller.saveFile();

        }else if(e.getSource().equals(createNewInvoiceBtn)){
            new NewInvoiceFrame().setVisible(true);

        }else if(e.getSource().equals(createItemBtn)){
               new CreateItemFrame().setVisible(true);

        }
    }

    public void jTable1MouseClicked(){
        controller.displayInvoiceDetails(invoicesTable,invoiceNumber,date,customerName
                                         ,invoiceTotal,itemsTable);
    }
}
