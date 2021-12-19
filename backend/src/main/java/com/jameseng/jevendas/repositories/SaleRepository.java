package com.jameseng.jevendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jameseng.jevendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
