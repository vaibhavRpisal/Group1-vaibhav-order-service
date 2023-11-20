package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enitities.Cart;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart, Long>{

}
