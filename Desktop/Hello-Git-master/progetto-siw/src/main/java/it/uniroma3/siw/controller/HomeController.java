package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/* Controller per accedere alla home page */
@Controller
public class HomeController {


	@RequestMapping("/index")
	public String home() {
		return "index";
	}

}
