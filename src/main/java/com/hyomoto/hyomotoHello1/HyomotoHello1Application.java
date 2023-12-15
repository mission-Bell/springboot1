package com.hyomoto.hyomotoHello1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.hyomoto.hyomotoHello1.model.Item;
import com.hyomoto.hyomotoHello1.repo.ItemRepo;

@EnableCaching
@SpringBootApplication
public class HyomotoHello1Application implements CommandLineRunner{
	
	@Autowired
	ItemRepo itemRepo;

	public static void main(String[] args) {
		SpringApplication.run(HyomotoHello1Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		itemRepo.save(new Item("banana","fruits"));
		itemRepo.save(new Item("apple","fruits"));		
		itemRepo.save(new Item("strovery","fruits"));		
		itemRepo.save(new Item("painapoer","fruits"));		
	}

}
