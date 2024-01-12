package com.SweetHome.PaymentService.dao;

import com.SweetHome.PaymentService.entities.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailsEntityDao extends JpaRepository<TransactionDetailsEntity,Integer> {

}
