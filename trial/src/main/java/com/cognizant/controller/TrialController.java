package com.cognizant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.dao.LoginDao;

@Controller
public class TrialController {
	
	@Autowired
	LoginDao loginDao;
	
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
			mv.setViewName("welcome");
			return mv;
		}
		
		return log();
	}

}
