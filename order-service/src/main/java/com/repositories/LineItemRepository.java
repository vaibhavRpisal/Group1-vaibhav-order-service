package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enitities.LineItems;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface LineItemRepository extends JpaRepository<LineItems, Long>{

}
