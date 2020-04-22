package com.cognizant.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.cognizant.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserLoginDao {

	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public boolean userlogin(User user)
	{
		
		
		String sql = "Select * from User where userid=?,username=?";
		
		List<User> users = jdbcTemplate.query(sql,new Object[] {user.getId(),user.getName()},(rs,x) ->
													
				new User(rs.getString(1),rs.getString(2),rs.getString(3))
				
				);
		
		
		if(users.get(0)==null)
		{
			return false;
		}
		else if(users.get(0).getPassword().contentEquals(user.getPassword()))
		{
			return true;
		}
		
		return false;
		
	}
	
}
