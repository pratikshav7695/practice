package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Batches;
import com.example.entity.Offers;
import com.example.entity.Sports;
import com.example.entity.Users;
import com.example.repository.BatchesRepository;
import com.example.repository.OffersRepository;
import com.example.repository.SportsRepository;
import com.example.repository.UsersRepository;


@Transactional
@Service
@Component
public class UserServiceImpl implements IUserService {

	@Autowired	
	UsersRepository usersRepository;	
	@Autowired
	BatchesRepository batchesRepository;
	@Autowired
	SportsRepository sportRepository;
	@Autowired
	OffersRepository offerRepository;
	@Override
	public Users registerNewUser(Users newUser) {
		return usersRepository.saveAndFlush(newUser);		
	}

	@Override
	public List<Batches> getAllBatches() {		
		return batchesRepository.findAll();		
	}
	@Override
	public List<Sports> getAllSports() {
		return sportRepository.findAll();
	}

	@Override
	public List<Offers> getAllOffers() {
		return offerRepository.findAll();


	}
}


