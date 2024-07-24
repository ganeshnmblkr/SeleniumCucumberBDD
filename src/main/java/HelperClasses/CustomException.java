package HelperClasses;

public class CustomException extends  RuntimeException{
    public CustomException(String message,Exception e){
        super(message,e);
    }
}
