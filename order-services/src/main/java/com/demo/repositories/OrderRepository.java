package com.demo.repositories;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

	
}