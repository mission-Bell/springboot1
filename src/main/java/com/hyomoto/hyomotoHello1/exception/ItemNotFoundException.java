package com.hyomoto.hyomotoHello1.exception;



public class ItemNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1l;
    
    public ItemNotFoundException (long itemID){
        super("your choises item( itemID= "+ itemID + " ) is nothing!");
    }
    
    public void message(long itemID){
        
        
    }
    
    
}
