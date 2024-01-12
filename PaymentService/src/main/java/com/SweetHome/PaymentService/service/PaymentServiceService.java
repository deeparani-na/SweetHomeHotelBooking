package com.SweetHome.PaymentService.service;

import com.SweetHome.PaymentService.dto.TransactionDetailsDto;
import com.SweetHome.PaymentService.entities.TransactionDetailsEntity;

public interface PaymentServiceService {
    public TransactionDetailsEntity saveTransaction(TransactionDetailsEntity tr);
    public TransactionDetailsEntity getTransactionById(int id);
}
