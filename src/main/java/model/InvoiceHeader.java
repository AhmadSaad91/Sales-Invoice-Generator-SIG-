package model;

import java.util.ArrayList;

public class InvoiceHeader {
    private int invoiceNum;
    private String invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> items;


    public InvoiceHeader(int invoiceNum,String invoiceDate,String customerName){

        this.invoiceNum=invoiceNum;
        this.invoiceDate=invoiceDate;
        this.customerName=customerName;
    }

    public InvoiceHeader(int invoiceNum,String invoiceDate,String customerName,ArrayList<InvoiceLine> items){

        this(invoiceNum, invoiceDate, customerName);
        this.items=items;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<InvoiceLine> getItems() {
        return items;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setItems(ArrayList<InvoiceLine> items) {
        this.items = items;
    }

    public double getTotal(){

        double sum=0.0;
        for(InvoiceLine e:items){
            sum+=e.getItemTotal();
        }
        return sum;
    }

    public String printItems(){
        String items="";
        for(InvoiceLine e:this.items){
            items = items+e+"\n";
        }
        return items;
    }

    public String toString(){
        return getInvoiceNum() + "\n{" + "\n" + getInvoiceDate() +"," + "\n" + getCustomerName() + "\n" + printItems() +"}\n\n";
    }
}
