package com.jameseng.jevendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jameseng.jevendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
