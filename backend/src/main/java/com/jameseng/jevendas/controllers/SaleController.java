package com.jameseng.jevendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jameseng.jevendas.dto.SaleDTO;
import com.jameseng.jevendas.services.SaleService;

@RestController //essa casse será um controlador REST
@RequestMapping(value="/sales") //sales = será o caminho na url da requisição
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	//Primeiro endpoint - retorna uma página de vendas
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		
		Page<SaleDTO> list=service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
}