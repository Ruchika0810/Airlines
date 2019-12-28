package com.lti.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


	@Entity
	@Table(name="PAYMENT")
	public class Payment {

	@Id
	@GeneratedValue
	@Column(name="PAYMENT_ID")
	private int paymentId;

	@Column(name="PAYMENT_AMOUNT")
	private double paymentAmount;

	@Column(name="BANK_NAME")
	private String bankName;

	@Column(name="CARD_NUMBER")
	private double cardNumber;
	
	@Column(name="CVV")
	private int cvv;

	@Column(name="NAME_ON_CARD")
	private String nameOnCard;

	@Column(name="EXPIRATION_DATE")
	private LocalDate expieryDate;
	
	@OneToOne
	@JoinColumn(name="BOOKINGID")
	BookingDetails bookingdetails;

	public int getCvv() {
		return cvv;
	}
	
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	public BookingDetails getBookingdetails() {
		return bookingdetails;
	}
	
	public void setBookingdetails(BookingDetails bookingdetails) {
		this.bookingdetails = bookingdetails;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(double cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public LocalDate getExpieryDate() {
		return expieryDate;
	}

	public void setExpieryDate(LocalDate expieryDate) {
		this.expieryDate = expieryDate;
	}
	
	
	
}
