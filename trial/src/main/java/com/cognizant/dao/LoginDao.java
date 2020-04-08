package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.User;
@Repository
public class LoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean login(String password)
	{
		String sql="Select * from User where name='admin";
		
		List<User> user = jdbcTemplate.query(sql,(rs,x)-> new User(rs.getString(0),rs.getString(1)));
	
		String pass = user.get(0).getPassword();
		if(password.contentEquals(pass))
		{
			return true;
		}
		return false;
	}
	
}
