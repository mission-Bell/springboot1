package com.hyomoto.hyomotoHello1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name="itemtbl")
public class Item {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long itemID;
    private String itemName;
    private String itemCategory;
    
    
    public Item(){
        
    }
    
    public Item(String itemName, String itemCategory){
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        
    }
    
    
    public Long getItemID(){
        return itemID;
    }

    public String getItemName(){
        return itemName;
    }

    public String getItemCategory(){
        return itemCategory;
    }
    
    public void setItemID(long itemID){
        this.itemID = itemID;
        
    }
    public void setItemName(String itemName){
        this.itemName = itemName;
        
    }
        public void setItemCategory(String itemCategory){
        this.itemCategory = itemCategory;
        
    }
}
