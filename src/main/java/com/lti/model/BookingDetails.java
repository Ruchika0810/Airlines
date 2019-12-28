
package com.lti.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKING_DETAILS")
public class BookingDetails {
	 @Id
	 @GeneratedValue
	 @Column(name="BOOKING_ID")
	 private int bookingId;
	  
	 @Column(name="DATE_OF_JOURNEY")
	 private LocalDate dateOfJourney;
	 
	 @Column(name="BOOKING_STATUS")
	 private String bookingStatus;
	
	 @Column(name="FLIGHT_ID")
	 private int flightId;
	 
	 @ManyToOne
	 @JoinColumn(name="REGISTERATION_ID")
	 Registeration registeration;
	 
	 @OneToMany(mappedBy = "bookingDetails",cascade = CascadeType.ALL)
	 List<Passenger> passenger;
	 
	 @OneToOne(mappedBy = "bookingdetails")
	 Payment payment;

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

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", dateOfJourney=" + dateOfJourney + ", bookingStatus="
				+ bookingStatus + ", flightId=" + flightId + ", registeration=" + registeration + ", passenger="
				+ passenger + ", payment=" + payment + "]";
	}

	
	
	 
}
