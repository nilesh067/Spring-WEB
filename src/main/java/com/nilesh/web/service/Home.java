package com.nilesh.web.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Home {
	
	@RequestMapping("/")
    public String home(HttpServletRequest request,Model model) {
		model.addAttribute("message", "Hello Guest");
		return "home";
    }
	@RequestMapping("/home")
	public String indexHome(HttpServletRequest request,Model model) {
		model.addAttribute("message", "Hello User");
		return "home";
	}
}
