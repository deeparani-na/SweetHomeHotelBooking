package com.SweetHome.BookingService.controller;

import com.SweetHome.BookingService.dto.BookingInfoEntityDto;
import com.SweetHome.BookingService.dto.TransactionDetailsDto;
import com.SweetHome.BookingService.entities.BookingInfoEntity;
import com.SweetHome.BookingService.feign.PaymentServiceClient;
import com.SweetHome.BookingService.service.BookingServiceService;
import com.SweetHome.BookingService.utils.POJOConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/hotel")
public class BookingServiceController {
    @Autowired
    BookingServiceService bookingServiceService;
    @Autowired
    PaymentServiceClient paymentServiceClient;
    @PostMapping(value = "/booking",produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchRoomsInHotel(@RequestBody BookingInfoEntityDto bookingDto){
        BookingInfoEntity bookingEntity = POJOConvertor.covertBookingInfoDtoToEntity(bookingDto);
        BookingInfoEntity savedBookingEntity = bookingServiceService.acceptBookingDetails(bookingEntity);
        BookingInfoEntityDto savedBookingDto = POJOConvertor.covertBookingInfoEntityToDTO(savedBookingEntity);
        return new ResponseEntity(savedBookingDto, HttpStatus.CREATED);
    }
    @PostMapping(value="/booking/{bookingId}/transaction",produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity bookRoomsInHotel(@PathVariable(name="bookingId") int bookingId, @RequestBody TransactionDetailsDto transactionDto){
        if(!(transactionDto.getPaymentMode().equals("CARD")||transactionDto.getPaymentMode().equals("UPI"))){
            return new ResponseEntity("Invalid mode of payment",HttpStatus.BAD_REQUEST);
        }
        int transactionId = paymentServiceClient.getTransactionId(transactionDto);
        if(transactionId==0){
            return new ResponseEntity("Invalid Booking Id",HttpStatus.BAD_REQUEST);
        }
        BookingInfoEntity bookedEntity = bookingServiceService.updateTransactionForBooking(bookingId,transactionId);
        if(transactionId!=0){
            String message = "Booking confirmed for user with aadhaar number: "
                    + bookedEntity.getAadharNumber()
                    +    "    |    "
                    + "Here are the booking details:    " + bookedEntity.toString();
        }
        return new ResponseEntity(POJOConvertor.covertBookingInfoEntityToDTO(bookedEntity),HttpStatus.OK);
    }

}
