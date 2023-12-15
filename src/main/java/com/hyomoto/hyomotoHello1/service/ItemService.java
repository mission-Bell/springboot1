package com.hyomoto.hyomotoHello1.service;

import java.util.Optional;

import com.hyomoto.hyomotoHello1.exception.ItemNotFoundException;
import com.hyomoto.hyomotoHello1.model.Item;
import com.hyomoto.hyomotoHello1.model.MyHello;
import com.hyomoto.hyomotoHello1.repo.ItemRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ItemService {
    
    @Autowired
    private ItemRepo itemRepo;
    
    private RestTemplate restTemplate;
    
    private String SUCCESS = "Success!";
    private String FAILED = "Failed...";
    
    public ItemService (RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        
    }
    
    @Cacheable(value="itemCaches")
    public Iterable<Item> getAllItems(){
        return itemRepo.findAll();
        

    }
    
    @Cacheable(value="itemCache",key="#p0")
    public Item getItem(long itemID){
        
        Optional<Item> item_opt= itemRepo.findById(itemID);
        Item item = item_opt.orElseThrow( () -> new ItemNotFoundException(itemID));
        return item;

    }
    
    @CacheEvict(value="itemCaches",allEntries = true)
    public String addItem(Item item){
        
        try {
            
            itemRepo.save(item);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return FAILED;
            
        }
        return SUCCESS;        

    }
    

    @Caching(evict = {
        @CacheEvict(value="itemCaches",allEntries = true),
        @CacheEvict(value="itemCache",key="#p0")
    })
    public String updateItem(long itemID, Item item){

        
        try {
            Optional<Item> item_opt= itemRepo.findById(itemID);
            item_opt.orElseThrow( () -> new Exception());
            itemRepo.save(item);

        } catch (Exception e){
            System.out.println(e.getMessage());
            return FAILED;            
        }

        return SUCCESS;
    }

    public String deleteItem(long itemID){
        
        try {
            Optional<Item> item_opt= itemRepo.findById(itemID);
            Item item = item_opt.orElseThrow( () -> new Exception());
            itemRepo.delete(item);

        } catch (Exception e){
            System.out.println(e.getMessage());
            return FAILED;            
        }        

        return SUCCESS;
        
    }
    
    public MyHello callHelloAPI(){
        String url = "http://localhost:8081/myHello";
        MyHello myHello = restTemplate.getForObject(url, MyHello.class);
        
        return myHello;
        
    }
    
}
