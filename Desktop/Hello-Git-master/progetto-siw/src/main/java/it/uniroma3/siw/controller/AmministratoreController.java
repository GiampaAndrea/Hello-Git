package it.uniroma3.siw.controller;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AmministratoreController {

	
	  @RequestMapping("/profiloAmministratore")
	  public String profilo() {
		  return "profiloAmministratore";
	  }
	  // Login form
	  @RequestMapping("/login")
	  public String login() {
	    return "login";
	  }

	  // Login form with error
	  @RequestMapping("/login-error.html")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "login";
	  }


}
