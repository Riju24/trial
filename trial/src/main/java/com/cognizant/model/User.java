package com.cognizant.model;

public class User {

	private String id;
	private String name;
	private String password;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public User()
	{
		super();
	}
	
	public User(String id,String name, String password)
	{
		this.setId(id);
		this.name= name;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
