package model;

public class WrongFileFormatException extends Exception{

    public WrongFileFormatException(){
        this("WrongFileFormatException");
    }

    public WrongFileFormatException(String message){
        super(message);
    }
}
