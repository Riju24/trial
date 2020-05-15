package com.cognizant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.dao.DetailsDao;
import com.cognizant.dao.LoginDao;
import com.cognizant.dao.UserLoginDao;
import com.cognizant.model.Details;
import com.cognizant.model.User;
import com.cognizant.validation.UserValidation;

@Controller
public class TrialController {
	
	@Autowired
	LoginDao loginDao;
	
	@Autowired 
	UserLoginDao userLoginDao;
	
	@Autowired
	UserValidation userValidation;
	
	@Autowired
	DetailsDao detailsDao;
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder)
	{
		binder.addValidators(userValidation);
	}
	
	
	
	
	
	@RequestMapping(value="adminlog")
	public ModelAndView log()
	{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("adminlog");
		
		return mv;
	}
	
	
	@RequestMapping(value="adminlog", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		
		String pass= request.getParameter("password");
		if(loginDao.login(pass))
		{
			mv.setViewName("register");
			mv.addObject("username", "Admin");
			
			return mv;
		}
		
		mv.setViewName("redirect:adminlogin");
		return mv;
	}
	
	@RequestMapping(value="userlogin")
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("userlogin");
		
		return mv;
	}
	
	@RequestMapping(value="userlogin", method=RequestMethod.POST)
	public ModelAndView loguser(@ModelAttribute("user") @Validated User user,BindingResult result)
	{
		
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors())
		{
			mv.setViewName("userlogin");
			return mv;
		}
	
		
		if(userLoginDao.userlogin(user))
		{
			if(detailsDao.userPresent(user.getName()))
			{
				mv.setViewName("welcome");
				mv.addObject("username",user.getName());
			}
			else 
			{
			mv.setViewName("register");
			mv.addObject("username", user.getName());
			}
		}
		else
		{
			mv.setViewName("userlogin");
			mv.addObject("msg", "Wrong username or password");
		}
		
		return mv;
		
	}
	
	@RequestMapping(value="register")
	public ModelAndView registration()
	{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("register");
		return mv;
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("details") Details details)
	{
		ModelAndView mv = new ModelAndView();
		
		
		mv.addObject("username",details.getName());
		mv.setViewName("welcome");
		return mv;
	}
	

}
