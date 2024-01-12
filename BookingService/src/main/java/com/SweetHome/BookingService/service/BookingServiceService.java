package com.SweetHome.BookingService.service;

import com.SweetHome.BookingService.dto.TransactionDetailsDto;
import com.SweetHome.BookingService.entities.BookingInfoEntity;
import org.springframework.stereotype.Service;


public interface BookingServiceService {
    public BookingInfoEntity acceptBookingDetails(BookingInfoEntity bookingEntity);
    public BookingInfoEntity updateTransactionForBooking(int bookingId,int transactionId);
    public BookingInfoEntity getBookingDetailsById(int id);
}
