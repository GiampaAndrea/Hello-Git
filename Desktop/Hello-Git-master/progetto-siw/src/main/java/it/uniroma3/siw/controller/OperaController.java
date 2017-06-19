package it.uniroma3.siw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Opera;
import it.uniroma3.siw.repository.OperaRepository;
import it.uniroma3.siw.service.OperaService;

@Controller
public class OperaController {
	
	@Autowired
	OperaRepository operaRepository;
	OperaService operaService;

	@GetMapping("/inserisciOpera")
	public String showForm(Opera opera) {
	return "inserisciOpera";
	}
	
	@PostMapping("/opera")
	public String addOpera(@Valid @ModelAttribute Opera opera, BindingResult bindingResult, Model model){
		
		if(bindingResult.hasErrors()){
			return "inserisciOpera";
		} else {
			model.addAttribute(opera);
			operaService.addOpera(opera);
		}
		return "risultatoOpera";
	}
	

	@GetMapping("/h")
	public String getOneOpera(@PathVariable("id")Long id, Model model){
		model.addAttribute("opera", this.operaService.findOne(id));
		return "opera";
	}
	
	@GetMapping("/k")
	public String getOperaByTitolo(String titolo, Model model){
		model.addAttribute("operaByTitolo", this.operaRepository.findByTitolo(titolo));
		return "operaByTitolo";
	}
	
	@GetMapping("/y")
	public String getAllOpere(Model model){
		model.addAttribute("opere", this.operaService.findAll());
		return "listaOpere";
	}
	
}
