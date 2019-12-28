package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.BookingDetails;
import com.lti.model.Passenger;
import com.lti.repository.BookingDetailsRepository;

@Service
public class BookingDetailsService {

		@Autowired
		BookingDetailsRepository bookingDetailsRepository;
	
		public BookingDetails addBookingDetails(BookingDetails bookingDetails,List<Passenger> list) {
			
			for(int i=0;i<list.size();i++) {
				list.get(i).setBookingDetails(bookingDetails);
			}
			return bookingDetailsRepository.addBookingDetails(bookingDetails);
			
			
		}
		public BookingDetails cancelBooking(BookingDetails bookingDetails) {
			
			return bookingDetailsRepository.addBookingDetails(bookingDetails);
		}

		public BookingDetails cancle(int id) {
			
		BookingDetails details = bookingDetailsRepository.cancleTicket(id);


		return details;
		}
}
