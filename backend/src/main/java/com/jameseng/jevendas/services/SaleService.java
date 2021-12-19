package com.jameseng.jevendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jameseng.jevendas.dto.SaleDTO;
import com.jameseng.jevendas.dto.SaleSuccessDTO;
import com.jameseng.jevendas.dto.SaleSumDTO;
import com.jameseng.jevendas.entities.Sale;
import com.jameseng.jevendas.repositories.SaleRepository;
import com.jameseng.jevendas.repositories.SellerRepository;

@Service //componente Service do sistema
public class SaleService {
	
	@Autowired //injeta a dependencia de forma transparente (o framework injeta a dependência automaticamente)
	private SaleRepository repository;
	
	@Autowired 
	private SellerRepository sellerRepository;
	
	//busca paginada de vendas:
	@Transactional(readOnly=true) //não precisa fazer looking no banco de dados
	public Page<SaleDTO> findAll(Pageable pageable){
		
		sellerRepository.findAll(); //vai buscar e gravar todos os vendedores no cash, e não deve ficar voltando ao banco de dados
		
		Page<Sale> result=repository.findAll(pageable);
		
		//converte a List<Sale> result em uma List<SellerDTO>
		//return result.stream().map(x -> new SaleDTO(x)).collect(Collectors.toList());
		
		return result.map(x -> new SaleDTO(x));
	}
	
	//Total de vendas (R$) por vendedor
	@Transactional(readOnly=true) //não precisa fazer looking no banco de dados
	public List<SaleSumDTO> amountGroupedBySeller() {
		
		return repository.amountGroupedBySeller();
	}
	
	//taxa de sucesso (%) por vendedor
	@Transactional(readOnly=true) //não precisa fazer looking no banco de dados
	public List<SaleSuccessDTO> successGroupedBySeller() {
		
		return repository.successGroupedBySeller();
	}
}
