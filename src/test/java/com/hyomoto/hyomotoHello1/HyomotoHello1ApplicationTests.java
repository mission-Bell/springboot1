package com.hyomoto.hyomotoHello1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyomoto.hyomotoHello1.controller.MyController;
import com.hyomoto.hyomotoHello1.exception.ItemNotFoundExceptionControllerAdvice;
import com.hyomoto.hyomotoHello1.repo.ItemRepo;
import com.hyomoto.hyomotoHello1.service.ItemService;

import org.assertj.core.api.Assertions;

@SpringBootTest
class HyomotoHello1ApplicationTests {
	
	@Autowired
	private MyController myController;
	
	@Autowired
	private ItemService itemService;	

	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private ItemNotFoundExceptionControllerAdvice itemNotFoundExceptionControllerAdvice;
	
	@Test
	void contextLoads() {
		Assertions.assertThat(myController).isNotNull();
		Assertions.assertThat(itemService).isNotNull();
		Assertions.assertThat(itemRepo).isNotNull();
		Assertions.assertThat(itemNotFoundExceptionControllerAdvice).isNotNull();

	}

}
