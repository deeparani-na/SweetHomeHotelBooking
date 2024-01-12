package com.SweetHome.BookingService.feign;

import com.SweetHome.BookingService.dto.TransactionDetailsDto;
import com.SweetHome.BookingService.entities.BookingInfoEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "api-gateway")
public interface PaymentServiceClient {
    @RequestMapping(value = "${paymentServiceApp.doTransactionPath}", method = RequestMethod.POST)
    public int getTransactionId(@RequestBody TransactionDetailsDto transactionDetailsDto);
}
