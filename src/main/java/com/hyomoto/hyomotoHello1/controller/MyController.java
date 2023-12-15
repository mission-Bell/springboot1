package com.hyomoto.hyomotoHello1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyomoto.hyomotoHello1.model.Item;
import com.hyomoto.hyomotoHello1.model.MyHello;
import com.hyomoto.hyomotoHello1.service.ItemService;

@RestController
public class MyController {
    
    @Autowired
    ItemService itemService;

    @GetMapping(value="/")
    public String index () {
        return "root!";
        
    }
    
    @GetMapping(value="test")
    public void test(String str){
        System.out.println(str);
        
    }
    
    @GetMapping(value="item")
    public Iterable<Item> getAllItems(){
        
        return itemService.getAllItems();
        
    }
    
    @GetMapping(value="item/{itemID}")
    public Item getItem(@PathVariable("itemID") long itemID){
        return itemService.getItem(itemID);
        
    }
    
    @GetMapping(value="callHello")
    public MyHello callMyHelloAPI(){
        return itemService.callHelloAPI();
        
    }
    
    @PostMapping(value="item")
    public String addItem(@RequestBody Item item){
        return itemService.addItem(item);
        
    }
    
    @PutMapping(value="item/{itemID}")
    public String updateItem(@PathVariable("itemID") long itemID ,@RequestBody Item item){
        return itemService.updateItem(itemID, item);
        
    }
    
    @DeleteMapping(value="item/{itemID}")
    public String deleteItem(@PathVariable("itemID") long itemID){
        return itemService.deleteItem(itemID);
        
    }
    
    

    
}



