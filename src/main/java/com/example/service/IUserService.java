package com.example.service;

import java.util.List;

import com.example.entity.Batches;
import com.example.entity.Offers;
import com.example.entity.Sports;
import com.example.entity.Users;

public interface IUserService {
	public Users registerNewUser(Users newUser);	
	public List<Batches> getAllBatches();	
	public List<Sports> getAllSports();
	public List<Offers> getAllOffers();
}
