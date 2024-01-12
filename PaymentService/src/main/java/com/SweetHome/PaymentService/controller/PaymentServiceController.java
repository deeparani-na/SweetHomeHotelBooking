package com.SweetHome.PaymentService.controller;

import com.SweetHome.PaymentService.dto.TransactionDetailsDto;
import com.SweetHome.PaymentService.entities.TransactionDetailsEntity;
import com.SweetHome.PaymentService.service.PaymentServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/payment")
public class PaymentServiceController {
    @Autowired
    PaymentServiceService paymentServiceService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping(value = "/transaction",produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity doTransaction(@RequestBody TransactionDetailsDto trDto){
        TransactionDetailsEntity trEntity = new TransactionDetailsEntity();
        trEntity.setPaymentMode(trDto.getPaymentMode());
        trEntity.setBookingId(trDto.getBookingId());
        trEntity.setCardNumber(trDto.getCardNumber());
        trEntity.setUpiId(trDto.getUpiId());
        TransactionDetailsEntity savedEntity = paymentServiceService.saveTransaction(trEntity);
        return new ResponseEntity(savedEntity.getTransactionId(), HttpStatus.CREATED);
    }
    @GetMapping(value = "/transaction/{transactionId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTransactionDetails(@PathVariable(name="transactionId") int transactionId){
        TransactionDetailsEntity trEntity = paymentServiceService.getTransactionById(transactionId);
        TransactionDetailsDto trDto = modelMapper.map(trEntity,TransactionDetailsDto.class);
        return new ResponseEntity(trDto,HttpStatus.OK);
    }
}
