package com.nagarro.yourmartapi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.yourmartapi.entity.Admin;
import com.nagarro.yourmartapi.exceptions.InvalidCredentialException;
import com.nagarro.yourmartapi.repository.AdminRepository;

@Controller
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;
	
	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		return "login";
	}

	@RequestMapping(value="/admin/login", method = RequestMethod.POST)
	public String getAdminLoggedIn(ModelMap model,@RequestParam("username") String username,@RequestParam("password") String password,
									HttpServletRequest request, HttpServletResponse response) {
		try{
			Admin admin = adminRepository.authenticate(username,password);
			request.getSession().setAttribute("admin",admin);
			model.clear();
			return "redirect:/admin/home";
		}catch(Exception e) {
			model.addAttribute("logInError","Invalid Credentials");
			return "login";
		}
	}
	
	@RequestMapping(value="/admin/home",method = RequestMethod.GET)
	public String homePage(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		if(session!=null && session.getAttribute("admin")!=null) {
			return "home";
		}
		return "redirect:/admin/login";
	}
	
	@RequestMapping(value="/admin/logout",method = RequestMethod.POST)
	public String adminLogout(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		if(session!=null && session.getAttribute("admin")!=null) {
			session.setAttribute("admin", null);
		}
		return "redirect:/admin/login";
	}
}
