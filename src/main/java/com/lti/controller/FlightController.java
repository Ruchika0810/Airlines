package com.lti.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.lti.dto.PassengerDetailsDto;
import com.lti.model.BookingDetails;
import com.lti.model.FlightSchedule;
import com.lti.model.FlightsDetails;
import com.lti.model.Passenger;
import com.lti.model.Payment;
import com.lti.model.Registeration;
import com.lti.service.BookingDetailsService;
import com.lti.service.BookingHistoryService;
import com.lti.service.FlightDetailsService;
import com.lti.service.LoginService;
import com.lti.service.PassengerService;
import com.lti.service.PaymentService;
import com.lti.service.RegisterationService;

@Controller
@SessionAttributes({"passengers","classPrice","source","destination","flightId","tot",
	"loggedInPassenger","date","loggedUser","booking","details","cancleTicketBooking","dept","arrive"})
public class FlightController {

		@Autowired
		FlightDetailsService flightDetailsService;
		
		@InitBinder
		public void initBinder(WebDataBinder binder) {
			binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
				@Override
				public void setAsText(String text) throws IllegalArgumentException {
					setValue(LocalDate.parse(text, DateTimeFormatter.ISO_DATE));
				}

				@Override
				public String getAsText() throws IllegalArgumentException {
					return DateTimeFormatter.ofPattern("yyyy-MM-dd").format((LocalDate) getValue());
				}

			});
		}
		
		@RequestMapping(path="/flight.lti", method = RequestMethod.POST)
		public String fetchFlight(ModelMap model,@RequestParam("source")String source, @RequestParam("destination")String destination, 
				@RequestParam("from")LocalDate travelDate,@RequestParam("passengers") int passengers
				){
			List<FlightSchedule> details ;
			try{
				details=flightDetailsService.fetchFlight(source, destination, travelDate,passengers);
				model.put("flightList", details);        
				model.put("source", details.get(0).getFlightsDetails().getSource());
				model.put("destination", details.get(0).getFlightsDetails().getDestination());
				model.put("passengers", passengers);
				model.put("date", travelDate);
				return "FlightSelect.jsp";
			}
			catch(Exception e) {
				model.put("fail", "No Flights Found");
				return "Failure.jsp";
			}
			
		}
		
		@Autowired
		private LoginService loginService;
		
		@RequestMapping(path="/login.lti",method=RequestMethod.POST)
		public String loginFlight(@RequestParam("email") String email,@RequestParam("password") String password,ModelMap model) {
		
			try {
				Registeration login = loginService.login(email, password);
				String name=login.getFirstname();
				model.put("loggedInPassenger",name);
				model.put("loggedUser",login);
				return "FlightSearch.jsp";
			}
			catch(Exception e) {
				
				System.out.println("error aaya "+e.getMessage());
				return "fail.jsp";
			}
		}
		
		@Autowired
		private RegisterationService registerationService;
		
		@RequestMapping(path = "/addDetails.lti", method = RequestMethod.POST)
		public String addNewDetails(Registeration registeration) {//,@RequestParam("dateOfBirth") String dob) {
			
				
			registerationService.addUsers(registeration);
			
			return "Login.jsp";
		}
		
		@Autowired
		private PassengerService passengerService;
		
		@RequestMapping(path="/addPassenger.lti", method = RequestMethod.POST)
		public String addPassengerDetails(PassengerDetailsDto passengerDetailsDto,ModelMap model) {
			List<Passenger> passengers = passengerDetailsDto.getPassengers();
			  model.put("booking", passengers);
			//passengerService.passengerDetails(passengers);
			return "Booking.jsp";
		}
		
		@RequestMapping(path="/flightSelect.lti",method = RequestMethod.POST)
		public String flightSelect(@RequestParam("flightclass") double price,ModelMap model,
				@RequestParam("flightId")int id,@RequestParam("deptTime") String dept,
				@RequestParam("arrTime")String arrive) {
			model.put("classPrice", price);
			model.put("flightId", id);
			model.put("dept", dept);
			model.put("arrive", arrive);
			Integer pass=(Integer)model.get("passengers");
			Double total= pass*price;
			model.put("tot", total);
			return "passenger.jsp";
		}
		
		
		@Autowired
		BookingDetailsService bookingDetailsService;
		
		@RequestMapping(path="/booking.lti")
		public String bookingDetails(ModelMap model) {
			LocalDate travelDate =(LocalDate) model.get("date");
			int flightId=(Integer) model.get("flightId");
			Registeration loggedUser = (Registeration) model.get("loggedUser");
		
			List<Passenger> list = (List<Passenger>) model.get("booking");
			
			BookingDetails bookingDetails = new BookingDetails();
			bookingDetails.setBookingStatus("Confirm");
			bookingDetails.setDateOfJourney(travelDate);
			bookingDetails.setPassenger(list);
			bookingDetails.setRegisteration(loggedUser);
			bookingDetails.setFlightId(flightId);
			
			
			BookingDetails details=bookingDetailsService.addBookingDetails(bookingDetails,list);
			model.put("details", details);
			
			return "payment.jsp";
		}
		
		@Autowired
		private PaymentService paymentService;
		
		@RequestMapping(path = "/addPayment.lti", method = RequestMethod.POST)
		public String addnewPayment(Payment payment,ModelMap model) {
			
			BookingDetails bookingDetails= (BookingDetails) model.get("details");
			Double amount=(Double)model.get("tot");
			payment.setBookingdetails(bookingDetails);
			payment.setPaymentAmount(amount);
			paymentService.addPaymentDetails(payment) ;
			
			int id=(Integer) model.get("flightId");
			FlightsDetails flightsDetails=flightDetailsService.findFlightDetails(id);
			
			int seat=flightsDetails.getSeatAvailablity();
			int passenegers=(Integer)model.get("passengers");
			int totalSeats= seat-passenegers;
			flightsDetails.setSeatAvailablity(totalSeats);
			flightDetailsService.saveFlightDetals(flightsDetails);
			return "ticket.jsp";
		}
		
		@Autowired
		BookingHistoryService bookingHistoryService;
		
		@RequestMapping(path="/bookingHistory.lti")
		public String viewBookingDetails(ModelMap model) {
			Registeration registeration=(Registeration) model.get("loggedUser");
			int id= registeration.getRegisterationId();
			List<BookingDetails> bookingHist=bookingHistoryService.viewBookingDetails(id);
			model.put("bk", bookingHist);
			return"BookingHistory.jsp";
		}
		
		@RequestMapping(path="/cancleBooking.lti", method=RequestMethod.POST)
		public String cancleBooking(@RequestParam("bid") int bookingId, ModelMap model) {

		BookingDetails details = bookingDetailsService.cancle(bookingId);

		model.put("cancleTicketBooking", details);
		model.put("bookingId", bookingId);
		return "cancleTicket.jsp";
		}

		@RequestMapping(path="/finalCancellation.lti", method = RequestMethod.POST)
		public String finalCancle(ModelMap model ) {
		
		BookingDetails bookingDetails=(BookingDetails) model.get("cancleTicketBooking");
		bookingDetails.setBookingStatus("Cancelled");
		bookingDetailsService.cancelBooking(bookingDetails);
		
		return "cancelConfirm.jsp";
		}
}		
