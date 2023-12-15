package com.hyomoto.hyomotoHello1.controller;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyomoto.hyomotoHello1.model.Item;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
public class MyControllerTest {
    
    
    @Autowired
    MockMvc mocMvc;
    
    private long itemID = 1L;
    private String itemName = "banana";
    private String itemCategory = "fruits";
    
    @Test
    void getItemTest() throws Exception{
        String responseJsonString = mocMvc.perform(MockMvcRequestBuilders.get("/item/{id}",itemID)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                                        .characterEncoding("UTG-8"))
                                        .andExpect(MockMvcResultMatchers.status().isOk())
                                        .andReturn().getResponse().getContentAsString();
                                        
        ObjectMapper objectMapper = new ObjectMapper();
        
        Item responseItem = objectMapper.readValue(responseJsonString,Item.class);
        
        Assertions.assertThat(responseItem.getItemID()).isEqualTo(itemID);
        Assertions.assertThat(responseItem.getItemName()).isEqualTo(itemName);
        Assertions.assertThat(responseItem.getItemCategory()).isEqualTo(itemCategory);
        
        
    }
    
    

    
}