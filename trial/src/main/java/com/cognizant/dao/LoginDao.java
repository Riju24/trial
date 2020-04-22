package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.User;
@Repository
public class LoginDao {

	private String admin_name="admin";
	private String admin_password="pa55w0rd";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean login(String password)
	{
		if(password.contentEquals(admin_password))
		{
			return true;
		}
		return false;
	}
	
}
