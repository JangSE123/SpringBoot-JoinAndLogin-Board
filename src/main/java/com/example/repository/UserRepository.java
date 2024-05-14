package com.example.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.entity.EntityUser;

import jakarta.transaction.Transactional;

public interface UserRepository extends CrudRepository<EntityUser, Integer>{

//	@Query("SELECT u FROM EntityUser u where u.user_name = :userName")
//	List<EntityUser> findUserData(String userName);
//	
//	@Query(value = "SELECT * FROM Entity_User WHERE user_age = :userAge", nativeQuery = true)
//	List<EntityUser> findUserDataQuery(String userAge);
	
	@Query(value = "SELECT * FROM EntityUser WHERE username = :userName and userpw = :userPw", nativeQuery = true)
	List<EntityUser> loginUserData(String userName, String userPw);

	@Query(value = "select * from EntityUser where " + "username=:userName and userpw=:userPw", nativeQuery = true)
	List<EntityUser> findUserPass(String userName, String userPw);
	
	List<EntityUser>findByUsernameAndUserpw(String userName, String userPw);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE EntityUser SET userpw = :newPw WHERE username = :userName and userpw = :userPw")
	int updateUserPw(String userName, String userPw, String newPw);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM EntityUser WHERE username = :userName and userpw = :userPw")
	int deleteUser(String userName, String userPw);
	
}
