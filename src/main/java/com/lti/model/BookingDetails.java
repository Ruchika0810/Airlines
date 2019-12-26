package com.lti.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class BookingDetails {
	 @Id
	 private int bookingId;
	 private LocalDate dateOfJourney;
	 private String bookedBy;
	 private String bookedClass;
	 private String bookingStatus;
	
	 @OneToOne
	 @JoinColumn(name="REGISTERATION_ID")
	 Registeration registeration;
	 
	 @OneToMany
	 @JoinColumn(name="PASSENGER_ID")
	 List<Passenger> passenger;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public String getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}

	public String getBookedClass() {
		return bookedClass;
	}

	public void setBookedClass(String bookedClass) {
		this.bookedClass = bookedClass;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Registeration getRegisteration() {
		return registeration;
	}

	public void setRegisteration(Registeration registeration) {
		this.registeration = registeration;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}
	 
	 
}
