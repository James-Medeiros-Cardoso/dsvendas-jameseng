package com.jameseng.jevendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jameseng.jevendas.dto.SellerDTO;
import com.jameseng.jevendas.services.SellerService;

@RestController //essa casse será um controlador REST
@RequestMapping(value="/sellers") //sellers = será o caminho na url da requisição
public class SellerController {
	
	@Autowired
	private SellerService service;
	
	//Primeiro endpoint
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll() {
		
		List<SellerDTO> list=service.findAll();
		return ResponseEntity.ok(list);
	}
}
