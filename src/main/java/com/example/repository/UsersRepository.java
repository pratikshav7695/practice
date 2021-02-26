package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	public Users findByUserName(String userName);
	
	@Transactional
	@Modifying
	public void deleteByUserName(String userName);
	
	@Transactional
	@Modifying
	@Query("UPDATE Users u SET u.userName=?1,u.userEmail=?2,u.userPassword=?3,u.userPhone=?4,u.userAddress=?5,u.userRole=?6,u.userBloodGroup=?7,u.isActive=?8,u.failedLoginCounts=?9 where userName=?10 ") 
	public void updateUserByName(String userName,String userEmail,String userPassword, String userPhone,String userAddress,String userRole,String userBloodGroup,boolean  isActive,int failedLoginCounts,String userName1);  
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Users u SET u.userId =?1,u.userName=?2,u.userEmail=?3,u.userPassword=?4,u.userPhone=?5,u.userAddress=?6,u.userRole=?7,u.userBloodGroup=?8,u.isActive=?9,u.failedLoginCounts=?10 where userId=?11 ") 
	public void updateUserById(int userId,String userName,String userEmail,String userPassword, String userPhone,String userAddress,String userRole,String userBloodGroup,boolean  isActive,int failedLoginCounts,int userId1);  
	
}
