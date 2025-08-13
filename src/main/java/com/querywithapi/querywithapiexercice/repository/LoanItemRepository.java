package com.querywithapi.querywithapiexercice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.querywithapi.querywithapiexercice.model.LoanItem;

@Repository
public interface LoanItemRepository extends JpaRepository<LoanItem, Long> {

}
