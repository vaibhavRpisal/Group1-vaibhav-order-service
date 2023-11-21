package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enitities.order;


public interface OrderRepository extends JpaRepository<order, Long>{

}
