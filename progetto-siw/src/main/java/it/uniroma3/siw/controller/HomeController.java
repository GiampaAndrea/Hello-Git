package it.uniroma3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* Controller per accedere alla home page */
@Controller
public class HomeController {


	@RequestMapping("/home")
	public String home() {
		return "/home";
	}

}
