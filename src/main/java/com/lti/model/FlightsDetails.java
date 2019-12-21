package com.lti.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Flight_Details")
public class FlightsDetails {
	
	@Id
	@GeneratedValue
	@Column(name="Flight_Id")
	private int flightId;
	
	private String source;
	

	private String destination;
	
	@Column(name="Economy_Price")
	private double economyPrice;
	
	@Column(name="Business_Price")
	private double businessPrice;
	
	@Column(name="Seat_Availability")
	private int seatAvailablity;
	
	@OneToMany(mappedBy = "flightsDetails")
	List<FlightSchedule> flightSchedules;
	
	public List<FlightSchedule> getFlightSchedules() {
		return flightSchedules;
	}
	
	public void setFlightSchedules(List<FlightSchedule> flightSchedules) {
		this.flightSchedules = flightSchedules;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getEconomyPrice() {
		return economyPrice;
	}

	public void setEconomyPrice(double economyPrice) {
		this.economyPrice = economyPrice;
	}

	public double getBusinessPrice() {
		return businessPrice;
	}

	public void setBusinessPrice(double businessPrice) {
		this.businessPrice = businessPrice;
	}

	public int getSeatAvailablity() {
		return seatAvailablity;
	}

	public void setSeatAvailablity(int seatAvailablity) {
		this.seatAvailablity = seatAvailablity;
	}

	@Override
	public String toString() {
		return "FlightsDetails flightID=" + flightId + ", source=" + source + ", destination=" + destination
				+ ", economyPrice=" + economyPrice + ", businessPrice=" + businessPrice + ", seatAvailablity="
				+ seatAvailablity  ;
	}
	
	
}
