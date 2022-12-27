package model;

public class WrongDateFormatException extends Exception{

    public WrongDateFormatException(){
        this("WrongDateFormatException");
    }

    public WrongDateFormatException(String message){
        super(message);
    }
}
