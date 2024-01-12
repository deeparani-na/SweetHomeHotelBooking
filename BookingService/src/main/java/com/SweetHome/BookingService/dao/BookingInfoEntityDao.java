package com.SweetHome.BookingService.dao;

import com.SweetHome.BookingService.entities.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingInfoEntityDao extends JpaRepository<BookingInfoEntity,Integer> {
}
