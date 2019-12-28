package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.BookingDetails;
import com.lti.repository.BookingHistoryRepository;

@Service
public class BookingHistoryService {
	@Autowired
	BookingHistoryRepository bookingHistoryRepository; 
	
	public List<BookingDetails> viewBookingDetails(int id) {
		return bookingHistoryRepository.viewBookingDetails(id);
	}
}
