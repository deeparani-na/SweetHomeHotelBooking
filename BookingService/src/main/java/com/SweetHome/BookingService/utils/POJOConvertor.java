package com.SweetHome.BookingService.utils;

import com.SweetHome.BookingService.dto.BookingInfoEntityDto;
import com.SweetHome.BookingService.entities.BookingInfoEntity;

public class POJOConvertor {
    public static BookingInfoEntityDto covertBookingInfoEntityToDTO(BookingInfoEntity bookingInfoEntity) {
        BookingInfoEntityDto bookingInfoEntityDto = new BookingInfoEntityDto();
        bookingInfoEntityDto.setId(bookingInfoEntity.getBookingId());
        bookingInfoEntityDto.setFromDate(bookingInfoEntity.getFromDate());
        bookingInfoEntityDto.setToDate(bookingInfoEntity.getToDate());
        bookingInfoEntityDto.setAadharNumber(bookingInfoEntity.getAadharNumber());
        bookingInfoEntityDto.setNumOfRooms(bookingInfoEntity.getNumOfRooms());
        bookingInfoEntityDto.setRoomNumbers(bookingInfoEntity.getRoomNumbers());
        bookingInfoEntityDto.setRoomPrice(bookingInfoEntity.getRoomPrice());
        bookingInfoEntityDto.setTransactionId(bookingInfoEntity.getTransactionId());
        bookingInfoEntityDto.setBookedOn(bookingInfoEntity.getBookedOn());
        return bookingInfoEntityDto;
    }

    public static BookingInfoEntity covertBookingInfoDtoToEntity(BookingInfoEntityDto bookingInfoEntityDto) {
        BookingInfoEntity bookingInfoEntity = new BookingInfoEntity();
        bookingInfoEntity.setBookingId(bookingInfoEntityDto.getId());
        bookingInfoEntity.setFromDate(bookingInfoEntityDto.getFromDate());
        bookingInfoEntity.setToDate(bookingInfoEntityDto.getToDate());
        bookingInfoEntity.setAadharNumber(bookingInfoEntityDto.getAadharNumber());
        bookingInfoEntity.setNumOfRooms(bookingInfoEntityDto.getNumOfRooms());
        bookingInfoEntity.setRoomNumbers(bookingInfoEntityDto.getRoomNumbers());
        bookingInfoEntity.setRoomPrice(bookingInfoEntityDto.getRoomPrice());
        bookingInfoEntity.setTransactionId(bookingInfoEntityDto.getTransactionId());
        bookingInfoEntity.setBookedOn(bookingInfoEntityDto.getBookedOn());
        return bookingInfoEntity;
    }
}
