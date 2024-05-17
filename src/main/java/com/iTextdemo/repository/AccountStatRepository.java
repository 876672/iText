package com.iTextdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iTextdemo.model.AccountStatement;


@Repository
public interface AccountStatRepository extends JpaRepository<AccountStatement, String>{

}
