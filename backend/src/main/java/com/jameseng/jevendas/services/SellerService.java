package com.jameseng.jevendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jameseng.jevendas.dto.SellerDTO;
import com.jameseng.jevendas.entities.Seller;
import com.jameseng.jevendas.repositories.SellerRepository;

@Service //componente Service do sistema
public class SellerService {
	
	@Autowired //injeta a dependencia de forma transparente (o framework injeta a dependência automaticamente)
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result=repository.findAll();
		//converte a List<Seller> result em uma List<SellerDTO>
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
