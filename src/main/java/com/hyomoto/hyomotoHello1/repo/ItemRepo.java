package com.hyomoto.hyomotoHello1.repo;

import org.springframework.stereotype.Repository;

import com.hyomoto.hyomotoHello1.model.Item;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ItemRepo extends CrudRepository<Item,Long> {
    
    
}
