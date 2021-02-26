package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Users;


public interface IAdminService {
		
	public void addManager(Users user);
	public List<Users> getAllManagers();
	public Users getManager(String userName);
	public void deleteManager(String userName);
	public void deleteManagerById(int userId);
	void updateManagerByName(Users user, String userName);
	public void updateManagerById(Users user,int userId);

}
