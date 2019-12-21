package com.lti.model;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Flight_Schedule")
public class FlightSchedule { 
	
	@Id
	@GeneratedValue
	@Column(name="FlightSchedule_Id")
	private int flightScheduleId;
	
	@Column(name="Schedule_Date")
	private LocalDate scheduleDate;
	
	@Column(name="Arrival_Time")
	private Time arrivalTime;
	
	@Column(name="Departure_Time")
	private Time departureTime;
	
	private Time duration;
	
	@ManyToOne
	@JoinColumn(name="flightId")
	FlightsDetails flightsDetails;

	public int getFlightScheduleId() {
		return flightScheduleId;
	}

	public FlightsDetails getFlightsDetails() {
		return flightsDetails;
	}

	public void setFlightsDetails(FlightsDetails flightsDetails) {
		this.flightsDetails = flightsDetails;
	}

	public void setFlightScheduleId(int flightScheduleId) {
		this.flightScheduleId = flightScheduleId;
	}

	public LocalDate getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(LocalDate scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	

	@Override
	public String toString() {
		return "FlightSchedule flightScheduleId=" + flightScheduleId + ", scheduleDate=" + scheduleDate
				+ ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", duration=" + duration
				;
	}
	
	
}
