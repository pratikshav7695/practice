package com.example.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Users;
import com.example.repository.UsersRepository;

@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	UsersRepository userRepository;
	
	@Override
	public void addManager(Users user) {
		userRepository.save(user);
	}

	@Override
	public List<Users> getAllManagers() {
		return userRepository.findAll();
	}

	@Override
	public Users getManager(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public void deleteManager(String userName) {
		userRepository.deleteByUserName(userName);
	}

	@Override
	public void deleteManagerById(int userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public void updateManagerByName(Users user,String userName) {
		userRepository.updateUserByName(userName,user.getUserEmail(), user.getUserPassword(),user.getUserPhone(), user.getUserAddress(), user.getUserRole(), user.getUserBloodGroup(), true, user.getFailedLoginCounts(),userName);
	}
	
	@Override
	public void updateManagerById(Users user,int userId) {
		userRepository.updateUserById(userId, user.getUserName(),user.getUserEmail(), user.getUserPassword(),user.getUserPhone(), user.getUserAddress(), user.getUserRole(), user.getUserBloodGroup(), true, user.getFailedLoginCounts(),userId);
	}

	


}
