package model;

public class InvoiceLine {
    private int invoiceNumber;
    private String itemName;
    private double itemPrice;
    private int count;


    public InvoiceLine(int invoiceNumber,String itemName,double itemPrice,int count){

        this.invoiceNumber=invoiceNumber;
        this.itemName=itemName;
        this.itemPrice=itemPrice;
        this.count=count;

    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getCount() {
        return count;
    }

    public double getItemTotal(){
        return itemPrice*count;
    }

    public String toString(){
        return getItemName() + "," + getItemPrice() + "," + getCount();
    }
}
