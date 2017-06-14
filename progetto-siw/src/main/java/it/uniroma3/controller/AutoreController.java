package it.uniroma3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.repository.AutoreRepository;
import it.uniroma3.service.AutoreService;

@Controller
public class AutoreController {

	@Autowired
	AutoreRepository autoreRepository;
	AutoreService autoreService;

	@GetMapping("/")
	public String getOneAutore(Long id, Model model){
		model.addAttribute("autore", this.autoreService.findOne(id));
		return "autore";
	}

	@GetMapping("/")
	public String getAutoriByNome(String nome, Model model){
		model.addAttribute("autoriByNome", this.autoreRepository.findByNome(nome));
		return "autoriByNome";
	}
	

	@GetMapping("/")
	public String getAllAutori(Model model){
		model.addAttribute("autori", this.autoreService.findAll());
		return "autori";
	}

}
