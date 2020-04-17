package com.ollie.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ollie.model.Shop;

public interface ShopRepo extends JpaRepository<Shop, Long> {

}
