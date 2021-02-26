package com.example.controller;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmailUtility;
import com.example.entity.Batches;
import com.example.entity.Offers;
import com.example.entity.Sports;
import com.example.entity.Users;
import com.example.service.UserServiceImpl;

@RestController 
@RequestMapping("/user")
public class UserController {	
	@Autowired
	UserServiceImpl userServiceImpl;
	@Autowired
	EmailUtility emailUtility;
	//Calling  registerNewUser() method of User Service class to register user
	@PostMapping("/register-new-user")
	public  ResponseEntity<?> registerNewUser(@RequestBody Users newUser) {	
		String to = newUser.getUserEmail();
		String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
		String msg = "Hello " + newUser.getUserName() +" Account Activation OTP is: " + otp;
		String subject = "Deccan Sports Club Account Activation";
		try {
			emailUtility.sendEmail(to, msg, subject);
		} catch (AddressException e) {
			e.getLocalizedMessage();
			
		} catch (MessagingException e) {
			e.getLocalizedMessage();
		}
		Users users	= userServiceImpl.registerNewUser(newUser);		
		if(users == null) {
			return  ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.body("no users found in Database");
		}else 
		{
			return  ResponseEntity.status(HttpStatus.FOUND).body(users); 	  
		}		 
	}
	@GetMapping(value = "/get-all-batches")
	public ResponseEntity<?> getBatches(){			 	
		List<Batches> listOfAllBatches = userServiceImpl.getAllBatches();
		if(listOfAllBatches.isEmpty()) {
			return  ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.body("No Batches found in Database");
		}else 
		{
			return  ResponseEntity.status(HttpStatus.FOUND).body(listOfAllBatches); 	  
		}
	}	
	@GetMapping(value = "/get-all-sports")
	public ResponseEntity<?> getSports(){				
		List<Sports> listOfAllSports =  userServiceImpl.getAllSports();
		if(listOfAllSports.isEmpty()) {
			return  ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.body("No Sports found in Database");
		}else 
		{
			return  ResponseEntity.status(HttpStatus.FOUND).body(listOfAllSports); 	  
		}
	}
	@GetMapping(value = "/get-all-offers")
	public ResponseEntity<?> getOffers(){		
		List<Offers> listOfAllOffers =  userServiceImpl.getAllOffers();
		if(listOfAllOffers.isEmpty()) {
			return  ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.body("No Offers found in Database");
		}else 
		{
			return  ResponseEntity.status(HttpStatus.FOUND).body(listOfAllOffers); 	  
		}
	}
}
