package it.uniroma3.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.model.Opera;
import it.uniroma3.repository.OperaRepository;
import it.uniroma3.service.OperaService;

@Controller
public class OperaController {
	
	@Autowired
	OperaRepository operaRepository;
	OperaService operaService;
	
	@PostMapping("/")
	public String addOpera(@Valid Opera opera, BindingResult bindingResult, Model model){
		
		if(bindingResult.hasErrors()){
			return "formAggiungiOpera";
		} else {
			model.addAttribute("opera", this.operaService.addOpera(opera));
		}
		return "opera";
	}
	
	@GetMapping("/")
	public String deleteOpera(Opera opera, Model model){
//		model.containsAttribute("opera", this.operaService.deleteOpera(opera));
		return "opera";
	}
	
	@GetMapping("/")
	public String getOneOpera(Long id, Model model){
		model.addAttribute("opera", this.operaService.findOne(id));
		return "opera";
	}
	
	@GetMapping("/")
	public String getOperaByTitolo(String titolo, Model model){
		model.addAttribute("operaByTitolo", this.operaRepository.findByTitolo(titolo));
		return "operaByTitolo";
	}
	
	@GetMapping("/")
	public String getAllOpere(Model model){
		model.addAttribute("opere", this.operaService.findAll());
		return "opere";
	}

}
