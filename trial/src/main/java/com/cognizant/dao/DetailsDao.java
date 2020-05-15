package com.cognizant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cognizant.model.Details;

@Service
public class DetailsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void addDeatils(Details detail)
	{
		String sql ="Insert into Details values(?,?,?,?,?,?,?)";
		int x = jdbcTemplate.update(sql,detail.getName(),detail.getCompanyName(),detail.getMobile(),detail.getGender(),detail.getCountry(),detail.getState(),detail.getCity());
	}
	
	public boolean userPresent(String name)
	{
		
		String sql ="Select count(*) from Deatils where name=?";
		int count = jdbcTemplate.queryForObject(sql, new Object[] {name},Integer.class);
		
		if(count>0)
		{	
		return true;
		}
		return false;
	}
}
