package com.SweetHome.PaymentService.service;


import com.SweetHome.PaymentService.dao.TransactionDetailsEntityDao;
import com.SweetHome.PaymentService.dto.TransactionDetailsDto;
import com.SweetHome.PaymentService.entities.TransactionDetailsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceServiceImpl implements PaymentServiceService {
    @Autowired
    TransactionDetailsEntityDao transactionDetailsDao;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public TransactionDetailsEntity saveTransaction(TransactionDetailsEntity trEntity) {
        return transactionDetailsDao.save(trEntity);
    }

    @Override
    public TransactionDetailsEntity getTransactionById(int id) {
        return transactionDetailsDao.findById(id).get();
    }
}
