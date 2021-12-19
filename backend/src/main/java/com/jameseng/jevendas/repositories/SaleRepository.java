package com.jameseng.jevendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jameseng.jevendas.dto.SaleSuccessDTO;
import com.jameseng.jevendas.dto.SaleSumDTO;
import com.jameseng.jevendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	//busca o total de vendas (R$) por vendedor
	@Query("SELECT new com.jameseng.jevendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP BY obj.seller") //busca agrupada onde o resultado será uma lista de SaleSumDTO
	List<SaleSumDTO> amountGroupedBySeller(); //assinatura do método

	//taxa de sucesso (%) por vendedor
	@Query("SELECT new com.jameseng.jevendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale AS obj GROUP BY obj.seller") // busca agrupada onde o resultado será uma lista de SaleSumDTO
	List<SaleSuccessDTO> successGroupedBySeller(); // assinatura do método
}
