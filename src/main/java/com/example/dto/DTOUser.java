//package com.example.dto;
//
//import com.example.entity.EntityUser;
//
//public class DTOUser {
//	public String User_Name;
//	public String User_Age;
//	
//	public DTOUser() {
//		User_Name = User_Age = "";
//	}
//	
//	public DTOUser(String user_Name, String user_Age) {
//		super();
//		User_Name = user_Name;
//		User_Age = user_Age;
//	}
//	public String getUser_Name() {
//		return User_Name;
//	}
//	public void setUser_Name(String user_Name) {
//		User_Name = user_Name;
//	}
//	public String getUser_Age() {
//		return User_Age;
//	}
//	public void setUser_Age(String user_Age) {
//		User_Age = user_Age;
//	}
//	public EntityUser ToEntity() {
//		return new EntityUser(-1, this.User_Name, this.User_Age);
//	}
//	
//}
//
//
////{
////  "User_Name":"dfdfd",
////  "User_Age":"1000"
////}

/////////////////////////////////////////////////////////Login//////////////////////
package com.example.dto;

import com.example.entity.EntityUser;

public class DTOUser {
	public String User_Name;
	public String User_Pw;
	
	public DTOUser() {
		User_Name = User_Pw = "";
	}
	
	public DTOUser(String user_Name, String user_Pw) {
		super();
		User_Name = user_Name;
		User_Pw = user_Pw;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public String getUser_Pw() {
		return User_Pw;
	}
	public void setUser_Pw(String user_Pw) {
		User_Pw = user_Pw;
	}
	public EntityUser ToEntity() {
		return new EntityUser(-1, this.User_Name, this.User_Pw);
	}
	
}