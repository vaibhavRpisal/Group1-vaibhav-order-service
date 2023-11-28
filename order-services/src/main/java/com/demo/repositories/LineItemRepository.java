package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.LineItem;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Long> {
    // Add custom queries if needed
}