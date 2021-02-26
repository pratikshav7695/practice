package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Users;
import com.example.service.IAdminService;


@RestController	
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	IAdminService adminServiceI;
	
	
	@GetMapping(value="/list-manager", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Users> getAllManagers(){
		return adminServiceI.getAllManagers();
	}
	
	
	@PostMapping(value="/add-manager")
	public String addManager(@RequestBody Users user) {
		Users users = new Users(user.getUserName(),user.getUserEmail(), user.getUserPassword(),user.getUserPhone(), user.getUserAddress(), user.getUserRole(), user.getUserBloodGroup(), true, user.getFailedLoginCounts());
		adminServiceI.addManager(users);
		return "Successfully added manager " +user.getUserName();
	}
	
	
	//****************************************
	@PutMapping("/update-manager-name/{userName}")
	public String updateManagerName(@RequestBody Users user, @PathVariable String userName){
		adminServiceI.updateManagerByName(user, userName);
		return "Successfully updated record: "+userName;
	}
	
	@DeleteMapping("/delete-manager-name/{userName}")
	public String deleteManagerByName(@PathVariable String userName){
		adminServiceI.deleteManager(userName);
		return "Successfully deleted record: " +userName;
	}
	//***************************************
	
	
	
	@PutMapping("/update-manager-id/{userId}")
	public String updateManagerId(@RequestBody Users user, @PathVariable int userId){
		adminServiceI.updateManagerById(user, userId);
		return "Successfully updated record: "+user.getUserName();
	}
	
	
	@DeleteMapping("/delete-manager-id/{userId}")
	public String deleteManagerById(@PathVariable int userId) {
		adminServiceI.deleteManagerById(userId);
		return "Successfully deleted record: " +userId;
	}
	
	
	
	
	
	
}
