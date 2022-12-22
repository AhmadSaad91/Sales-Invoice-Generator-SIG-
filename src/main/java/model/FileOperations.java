package model;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class FileOperations {


    //method to read 2 .csv files
    public ArrayList<InvoiceHeader> readFile() throws Exception{

        ArrayList<InvoiceHeader> invoices=new ArrayList<>();
        ArrayList<InvoiceLine> items=new ArrayList<>();

        File file1=new File("InvoiceHeader.csv");
        try {
            Scanner scanner=new Scanner(file1);
            while(scanner.hasNext()){

                    String[] data = scanner.nextLine().split(",");

                if(data.length !=3){
                    throw new Exception("Wrong File1 Format");
                }

                    if (!(data[1].matches("\\d{2}-\\d{2}-\\d{4}"))) {
                        throw new Exception("Wrong Date Format");
                    }
                        InvoiceHeader i = new InvoiceHeader(Integer.parseInt(data[0]), data[1], data[2]);
                        invoices.add(i);


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        File file2=new File("InvoiceLine.csv");
        try {
            Scanner scanner=new Scanner(file2);
            while(scanner.hasNext()){
                String[] data=scanner.nextLine().split(",");
                if(data.length !=4){
                    throw new Exception("Wrong File2 Format");
                }
                InvoiceLine i=new InvoiceLine(Integer.parseInt(data[0]),data[1],Double.parseDouble(data[2]),Integer.parseInt(data[3]));
                items.add(i);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(int i=0;i< invoices.size();i++){
            ArrayList<InvoiceLine> itemsTemp=new ArrayList<>();
            for(int j=0;j<items.size();j++){
                if(items.get(j).getInvoiceNumber()==invoices.get(i).getInvoiceNum()){
                    itemsTemp.add(items.get(j));
                }
            }
            invoices.get(i).setItems(itemsTemp);
        }
        return invoices;
    }




    //method to write into 2 .csv files
    public void writeFile(ArrayList<InvoiceHeader> invoices) {

        File file1=new File("InvoiceHeader.csv");
        File file2=new File("InvoiceLine.csv");

        FileWriter fw1= null;

        try {
            fw1 = new FileWriter(file1);

            BufferedWriter bw1 = new BufferedWriter(fw1);

            for (int i = 0; i < invoices.size(); i++) {

                bw1.write(invoices.get(i).getInvoiceNum() + "," + invoices.get(i).getInvoiceDate() + ","
                        + invoices.get(i).getCustomerName());

                bw1.newLine();
            }

            bw1.close();
            fw1.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter fw2= null;
        try {
            fw2 = new FileWriter(file2);

            BufferedWriter bw2 = new BufferedWriter(fw2);

            for (int i = 0; i < invoices.size(); i++) {
                for (int j = 0; j < invoices.get(i).getItems().size(); j++) {

                    bw2.write(invoices.get(i).getItems().get(j).getInvoiceNumber() + ","
                            + invoices.get(i).getItems().get(j).getItemName() + ","
                            + invoices.get(i).getItems().get(j).getItemPrice() + ","
                            + invoices.get(i).getItems().get(j).getCount());

                    bw2.newLine();
                }
            }

            bw2.close();
            fw2.close();

        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //main method to test reading from the 2 files
    public static void main(String[] args) {

        FileOperations files = new FileOperations();

        try {
            ArrayList<InvoiceHeader> invoices = files.readFile();

            for (InvoiceHeader e : invoices) {
                System.out.println(e.toString());
            }
        }catch (Exception e){
            System.out.println("Wrong Date Format");
        }
    }
}
