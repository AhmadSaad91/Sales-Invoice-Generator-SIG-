package controller;

import model.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Controller {
    private  FileOperations fileOperations=new FileOperations();
    private static ArrayList<InvoiceHeader> invoices;
    private ArrayList<InvoiceLine> items=new ArrayList<>();


    //methods used in MainFrame
    public void load(JTable invoicesTable){
        try {
            invoices = fileOperations.readFile();
            displayInvoicesTable(invoicesTable);
        }catch (WrongFileFormatException e){
            JOptionPane.showMessageDialog(
                    null,
                    "Wrong File Format",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
        }catch (WrongDateFormatException e){
            JOptionPane.showMessageDialog(
                    null,
                    "Wrong Date Format",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
        } catch(Exception e){

            e.printStackTrace();
        }
    }

    public void displayInvoicesTable(JTable invoicesTable) {
        try {
            DefaultTableModel model = (DefaultTableModel) invoicesTable.getModel();
            model.setNumRows(0);
            Object rowData[] = new Object[4];
            for (int i = 0; i < invoices.size(); i++) {
                rowData[0] = invoices.get(i).getInvoiceNum();
                rowData[1] = invoices.get(i).getInvoiceDate();
                rowData[2] = invoices.get(i).getCustomerName();
                rowData[3] = invoices.get(i).getTotal();
                model.addRow(rowData);
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    public void displayInvoiceDetails(JTable invoicesTable, JLabel invoiceNumber, JTextField date, JTextField customerName
            , JLabel invoiceTotal, JTable itemsTable) {
        DefaultTableModel model = (DefaultTableModel) invoicesTable.getModel();

        String iN = model.getValueAt(invoicesTable.getSelectedRow(), 0).toString();
        String d = model.getValueAt(invoicesTable.getSelectedRow(), 1).toString();
        String cN = model.getValueAt(invoicesTable.getSelectedRow(), 2).toString();
        String iT = model.getValueAt(invoicesTable.getSelectedRow(), 3).toString();

        invoiceNumber.setText(iN);
        date.setText(d);
        customerName.setText(cN);
        invoiceTotal.setText(iT);

        DefaultTableModel model2 = (DefaultTableModel) itemsTable.getModel();

        model2.setNumRows(0);

        Object rowData[] = new Object[5];

        for (int i = 0; i < invoices.size(); i++) {
            if ((invoices.get(i).getInvoiceNum()) == Integer.parseInt(iN)) {
                for (int j = 0; j < invoices.get(i).getItems().size(); j++) {
                    rowData[0] = invoices.get(i).getItems().get(j).getInvoiceNumber();
                    rowData[1] = invoices.get(i).getItems().get(j).getItemName();
                    rowData[2] = invoices.get(i).getItems().get(j).getItemPrice();
                    rowData[3] = invoices.get(i).getItems().get(j).getCount();
                    rowData[4] = invoices.get(i).getItems().get(j).getItemTotal();

                    model2.addRow(rowData);
                }
            }
        }
    }

    public void deleteInvoice(JTable invoicesTable,JLabel invoiceNumber, JTextField date, JTextField customerName
                            , JLabel invoiceTotal, JTable itemsTable){
        DefaultTableModel model=(DefaultTableModel) invoicesTable.getModel();

        if(invoicesTable.getSelectedRowCount()==1) {
            String iN=model.getValueAt(invoicesTable.getSelectedRow(),0).toString();
            for (int i = 0; i < invoices.size(); i++) {
                if ((invoices.get(i).getInvoiceNum()) == Integer.parseInt(iN)) {
                    invoices.remove(i);
                }
            }
            model.removeRow(invoicesTable.getSelectedRow());
            JOptionPane.showMessageDialog(
                    null,
                    "Invoice Deleted Successfully",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE
            );
            DefaultTableModel model2=(DefaultTableModel) itemsTable.getModel();
            model2.setNumRows(0);
            invoiceNumber.setText("");
            date.setText("");
            customerName.setText("");
            invoiceTotal.setText("");
        }else if(invoicesTable.getRowCount()==0){
            JOptionPane.showMessageDialog(
                    null,
                    "No invoices available",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
        }else if(invoicesTable.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(
                    null,
                    "Please select one record",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
        }

    }

    public void saveFile() {

        try {
            fileOperations.writeFile(invoices);
            JOptionPane.showMessageDialog(
                    null,
                    "File saved successfully",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }catch (Exception e){
            e.printStackTrace();
            }
    }

    public void deleteItem(JTable itemsTable,JLabel invoiceTotal){

        DefaultTableModel model=(DefaultTableModel) itemsTable.getModel();

        if(itemsTable.getSelectedRowCount()==1) {

            String iN=model.getValueAt(itemsTable.getSelectedRow(),0).toString();
            String itemName=model.getValueAt(itemsTable.getSelectedRow(),1).toString();

            for (int i = 0; i < invoices.size(); i++) {
                if ((invoices.get(i).getInvoiceNum()) == Integer.parseInt(iN)) {
                    for(int j=0;j<invoices.get(i).getItems().size();j++){
                        if(invoices.get(i).getItems().get(j).getItemName().equals(itemName)){
                            invoices.get(i).getItems().remove(j);
                            String s=String.valueOf(invoices.get(i).getTotal());
                            invoiceTotal.setText(s);
                            model.removeRow(itemsTable.getSelectedRow());
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Item Deleted Successfully",
                                    "Information",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }
                }
            }

        }else if(itemsTable.getRowCount()==0){
            JOptionPane.showMessageDialog(
                    null,
                    "Please select one invoice",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );

        }else if(itemsTable.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(
                    null,
                    "Please select one item",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
        }

    }


    //methods used in NewInvoiceFrame
    public void addItem(JTextField invoiceNumber,JTextField itemName,JTextField price,JTextField count){

        if(invoiceNumber.getText().equals("")){
            JOptionPane.showMessageDialog(
                    null,
                    "Please Enter Invoice Number",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }else if(itemName.getText().equals("")){
            JOptionPane.showMessageDialog(
                    null,
                    "Please Enter Item Name",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }else if(price.getText().equals("") || Double.parseDouble(price.getText())<1){
            JOptionPane.showMessageDialog(
                    null,
                    "Please Enter Valid Item Price",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }else if(count.getText().equals("") || Integer.parseInt(count.getText())<1){
            JOptionPane.showMessageDialog(
                    null,
                    "Please Enter at least One Count",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }else {
            InvoiceLine i = new InvoiceLine(Integer.parseInt(invoiceNumber.getText()), itemName.getText(), Double.parseDouble(price.getText()), Integer.parseInt(count.getText()));
            items.add(i);
            JOptionPane.showMessageDialog(
                    null,
                    "Item added successfully",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE
            );
            itemName.setText("");
            price.setText("");
            count.setText("");
        }
    }
    public void confirmNewInvoice(JTextField invoiceNumber,JTextField date,JTextField customerName,JFrame frame,JTable invoicesTable){

        if(invoiceNumber.getText().equals("")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please Enter Invoice Number",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }else if(!(date.getText().matches("\\d{2}-\\d{2}-\\d{4}"))) {
            JOptionPane.showMessageDialog(
                    null,
                    "Enter Date Format dd-mm-yyyy",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }else if(customerName.getText().equals("")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please Enter Customer Name",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }else if(items.isEmpty()){
            JOptionPane.showMessageDialog(
                    null,
                    "Please Add item(s)",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }else {
            InvoiceHeader i = new InvoiceHeader(Integer.parseInt(invoiceNumber.getText()), date.getText(), customerName.getText(), items);
            invoices.add(i);
            JOptionPane.showMessageDialog(
                    null,
                    "Invoice created successfully",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE
            );
            frame.setVisible(false);
            displayInvoicesTable(invoicesTable);
        }
    }

    //methods used in CreateItemFrame

    public void confirmNewItem(JTextField invoiceNum,JTextField itemName,JTextField price,JTextField count,JFrame frame,
                               JTable invoicesTable,JLabel invoiceNumber, JTextField date, JTextField customerName
            , JLabel invoiceTotal, JTable itemsTable) {

        if(invoiceNum.getText().equals("")){
            JOptionPane.showMessageDialog(
                    null,
                    "Please Enter Invoice Number",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }else if(itemName.getText().equals("")){
            JOptionPane.showMessageDialog(
                    null,
                    "Please Enter Item Name",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }else if(price.getText().equals("") || Double.parseDouble(price.getText())<1){
            JOptionPane.showMessageDialog(
                    null,
                    "Please Enter Valid Item Price",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }else if(count.getText().equals("") || Integer.parseInt(count.getText())<1){
            JOptionPane.showMessageDialog(
                    null,
                    "Please Enter at least One Count",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }else {

           InvoiceLine item=new InvoiceLine(Integer.parseInt(invoiceNum.getText()),itemName.getText(),
                   Double.parseDouble(price.getText()),Integer.parseInt(count.getText()));
           for(InvoiceHeader e:invoices){
               if(e.getInvoiceNum()==Integer.parseInt(invoiceNum.getText())){
                   e.getItems().add(item);
                   JOptionPane.showMessageDialog(
                           null,
                           "Item added successfully",
                           "Information",
                           JOptionPane.INFORMATION_MESSAGE
                   );

                   frame.setVisible(false);
                   displayInvoicesTable(invoicesTable);

                   DefaultTableModel model=(DefaultTableModel) itemsTable.getModel();
                   model.setNumRows(0);
                   invoiceNumber.setText("");
                   date.setText("");
                   customerName.setText("");
                   invoiceTotal.setText("");
               }
           }

        }

    }

}
