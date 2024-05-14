package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.DTOUser;
import com.example.entity.EntityUser;
import com.example.repository.UserRepository;
import com.example.service.ServiceUser;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	ServiceUser _serviceUser;
	
	@GetMapping("/Home")
	public String loginHome(Model m, HttpSession session) {
		
		if(session.getAttribute("LoginOK") == "LoginOk") {
			m.addAttribute("tableList", _serviceUser.GetAllUser());
			return "MyPage";
		}else {
			return "Login";

		}
	}
	@GetMapping("/Register")
	public String userPassChange(@PathVariable String id, @PathVariable String pass, @PathVariable String repass)
	{
//		_serviceUser.RePass(id, pass, repass);
		return "Login";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("LoginOK");
		return "Login";
	}
	
	@GetMapping("/Join")
	public String joinHome() {
		return "Join";
	}
	@GetMapping("/MakeDummy")
	public String makeDummy() {
		for(int i = 0; i < 10; i++) {
			DTOUser user = new DTOUser();
			user.User_Name = String.valueOf(i);
			user.User_Pw = String.valueOf(i);
			_serviceUser.Join(user);
		}
		return "Login";
	}
	
	@PostMapping("/Join")
	public String userRegister(DTOUser user, HttpSession session) {
		
		_serviceUser.Join(user);
		
		return "Login";
	}
	
	@PostMapping("/Login")
	public String userLogin(DTOUser user, Model m, HttpSession session) {
		
		EntityUser eu = (EntityUser)session.getAttribute("LoginOK");
//		if(session.getAttribute("LoginOK") == "LoginOk") {
		if(eu != null) {
			m.addAttribute("tableList", _serviceUser.GetAllUser());
			return "MyPage";
		}else {
			boolean b = _serviceUser.Login(user, session);
			
			if(b) {
				session.setAttribute("LoginOK", "LoginOk");
				m.addAttribute("tableList", _serviceUser.GetAllUser());
				return "MyPage";
			}else {
				return "Login";
			}
		}		
	}
	
	@PostMapping("/updatePw")
	public String update(DTOUser user, Model m, HttpSession session, @RequestParam("newPw") String newPw) {
	    _serviceUser.Update(user, newPw);
	    m.addAttribute("tableList", _serviceUser.GetAllUser());
	    return "MyPage";
	}
	
	@GetMapping("/deleteUser")
	public String delete(DTOUser user, Model m, HttpSession session) {
		_serviceUser.Delete(user);
		m.addAttribute("tableList", _serviceUser.GetAllUser());
		return "MyPage";
		
	}
	
	
//	@Autowired
//	UserRepository userRopo;
//	
//	
//	@GetMapping("/hello")
//	public String Hello(Model m) {
//		m.addAttribute("value", "hahaha");
//		return "template";
//	}
//	
//	@GetMapping("/getTest/{id}")
//	@ResponseBody
//	public String GetTest(@PathVariable int id) {
//		return String.valueOf(id);
//	}
//	
//	@GetMapping("/example/{id}")
//	public ResponseEntity<String> getExampleById(@PathVariable Long id) {
//		if (id == 1) {
//			return ResponseEntity.ok("Example with ID 1 found");
//		}else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Example not found");
//		}
//	}
//	
//	@PostMapping("/postTest")
//	@ResponseBody
//	public String PostTest(@RequestBody String param) {
//		return param;
//	}
	
//	@PostMapping("/dtoTest")
//	@ResponseBody
//	//@RequestBody를 작성할 경우 json타입 아니면 getseter사용해서 form타입으로 전송(415오류)
//	public String DTOTest(/* @RequestBody */ DTOUser user) {
//		userRopo.save(user.ToEntity());
////		System.out.println(user.User_Name);
////		System.out.println(user.User_Age);
//		return user.toString();
//	}
//	
//	@GetMapping("/dtoGetTest/{name}")
//	@ResponseBody
//	public String DTOGetTest(@PathVariable String name) {
//		List<EntityUser> list = userRopo.findUserData(name);
//		
//		if(list.size() == 0)
//			return "no user";
//		else
//			return list.get(0).getUser_name();
//	}
//	
//	@GetMapping("/dtoGetTestQuery/{age}")
//	@ResponseBody
//	public String DTOGetTestQuery(@PathVariable String age) {
//		List<EntityUser> list = userRopo.findUserDataQuery(age);
//		
//		if(list.size() == 0)
//			return "no user";
//		else
//			return list.get(0).getUser_age();
//	}
	
//	@PostMapping("/Join")
//	@ResponseBody
//	//@RequestBody를 작성할 경우 json타입 아니면 getseter사용해서 form타입으로 전송(415오류)
//	public String DTOTest(/* @RequestBody */ DTOUser user) {
//		userRopo.save(user.ToEntity());
//		System.out.println(user.User_Name);
//		System.out.println(user.User_Pw);
//		return "유저데이터 저장";
//	}
//	
//	
//	
//	@PostMapping("/Login")
//	@ResponseBody
//	public String UserLogin(DTOUser user) {
//		List<EntityUser> list = userRopo.loginUserData(user.User_Name, user.User_Pw);
//		
//		if(list.size() == 0)
//			return "로그인 실패";
//		else
//			return user.User_Name + "님 환영합니다.";
//	}
//	
//	
//	@GetMapping("/dtoDeleteTest/{id}")
//	@ResponseBody
//	public String DTODeleteTest(@PathVariable int id) {
//		userRopo.deleteById(id);
//		return "";
//	}

}