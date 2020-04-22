package com.cognizant.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cognizant.model.User;

@Component
public class UserValidation implements Validator 
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		User user = (User)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id","","Cannot be Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","","User Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","","Password is required");
	}

}
