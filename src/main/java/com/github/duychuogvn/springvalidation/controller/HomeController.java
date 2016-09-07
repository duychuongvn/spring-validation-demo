package com.github.duychuogvn.springvalidation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.duychuogvn.springvalidation.model.UserModel;

@Controller
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	MessageSource messageSource;
	@RequestMapping(value = "/home")
	public String home(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap model) {
		return "index";

	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String initRegisterUser(ModelMap model) {
		model.addAttribute("userModel", new UserModel());
		logger.info("======= Init user form");
		return "home";
	}

	@RequestMapping(value = "/registerUser.do", method = RequestMethod.POST)
	public String registerUser(@Valid UserModel userModel,
			BindingResult bindingResult, Model model) {
		model.addAttribute("userModel", userModel);
		if (bindingResult.hasErrors()) {
			// handle error
			logger.error("===Got error");
			return "home";
		} else {
			logger.info("=== No error");
			// insert into database
		}
		return "registerUserSuccess";
	}
}
