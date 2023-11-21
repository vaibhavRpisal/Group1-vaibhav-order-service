package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enitities.ordering;
@Repository
public interface OrderingRepository extends JpaRepository<ordering, Long>{

}
