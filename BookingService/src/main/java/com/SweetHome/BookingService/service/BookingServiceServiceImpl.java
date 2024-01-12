package com.SweetHome.BookingService.service;

import com.SweetHome.BookingService.dao.BookingInfoEntityDao;
import com.SweetHome.BookingService.entities.BookingInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Random;
@Service
public class BookingServiceServiceImpl implements BookingServiceService{

    @Autowired
    private BookingInfoEntityDao bookingInfoEntityDao;

    @Override
    public BookingInfoEntity acceptBookingDetails(BookingInfoEntity bookingEntity) {
        BookingInfoEntity newBooking = new BookingInfoEntity();
        newBooking.setFromDate(bookingEntity.getFromDate());
        newBooking.setToDate(bookingEntity.getToDate());
        newBooking.setAadharNumber(bookingEntity.getAadharNumber());
        newBooking.setRoomNumbers(getRandomNumbers(bookingEntity.getNumOfRooms()).toString());
        Period period = Period.between(bookingEntity.getToDate(),bookingEntity.getFromDate());
        int diff = Math.abs(period.getDays());
        int roomPrice = 1000* bookingEntity.getNumOfRooms()*(diff);
        newBooking.setRoomPrice(roomPrice);
        newBooking.setTransactionId(0);
        newBooking.setBookedOn(LocalDateTime.now());
        return bookingInfoEntityDao.save(newBooking);
    }

    @Override
    public BookingInfoEntity updateTransactionForBooking(int bookingId,int transactionId) {
        BookingInfoEntity bookingEntity = getBookingDetailsById(bookingId);
        bookingEntity.setTransactionId(transactionId);
        return bookingInfoEntityDao.save(bookingEntity);
    }

    @Override
    public BookingInfoEntity getBookingDetailsById(int id) {
        return bookingInfoEntityDao.findById(id).get();
    }

    public static ArrayList<String> getRandomNumbers(int count){
        Random rand = new Random();
        int upperBound = 100;
        ArrayList<String>numberList = new ArrayList<String>();
        for (int i=0; i<count; i++){
            numberList.add(String.valueOf(rand.nextInt(upperBound)));
        }
        return numberList;
    }
}
