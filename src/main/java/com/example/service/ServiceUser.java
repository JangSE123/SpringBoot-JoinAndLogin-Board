package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DTOUser;
import com.example.entity.EntityUser;
import com.example.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class ServiceUser {
	@Autowired
	UserRepository userRopo;
	
	public void Join(DTOUser user) {
		System.out.println(user.User_Name);
		System.out.println(user.User_Pw);
		
		userRopo.save(user.ToEntity());
//		EntityUser eu = userRopo.save(user.ToEntity());
//		eu.setUser_name("dkfljd");
//		userRopo.delete(eu);
//		userRopo.save(eu);
	}
	public void Update(DTOUser user, String newPw) {
	    System.out.println(user.User_Name);
	    System.out.println(user.User_Pw);
	    System.out.println(newPw);
	    
	    userRopo.updateUserPw(user.User_Name, user.User_Pw, newPw);
	}
	public void Delete(DTOUser user) {
	    System.out.println(user.User_Name);
	    System.out.println(user.User_Pw);
	    
	    userRopo.deleteUser(user.User_Name, user.User_Pw);
		
	}
	
	public boolean Login(DTOUser user, HttpSession session) {
		System.out.println(user.User_Name);
		System.out.println(user.User_Pw);
		
//		List<EntityUser> list = (userRopo).findUserPass(
//				user.User_Name,
//				user.User_Pw);
		List<EntityUser> list = userRopo.findByUsernameAndUserpw(
				user.User_Name,
				user.User_Pw);
		
		
//		list.get(0)
//		userRopo.save(list.get(0));
		
		if(list.size() == 0) {
			return false;
		}else {
			session.setAttribute("LoginOK", list.get(0));
			return true;
		}
	}
	
	public void RePass(String id, String pass, String rePass) {
		List<EntityUser> list = userRopo.findByUsernameAndUserpw(id, pass);
//		if(list.size() > 0) {
//			list.get(0).setUser_pw(rePass);
//			userRopo.save(list.get(0));
//		}
	}
	
	public Iterable<EntityUser> GetAllUser() {
		return userRopo.findAll();
	}
	
	

}
