package it.uniroma3.siw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.model.Opera;
import it.uniroma3.siw.repository.OperaRepository;
import it.uniroma3.siw.service.AutoreService;
import it.uniroma3.siw.service.OperaService;

@Controller
public class OperaController {
	
	@Autowired
	OperaRepository operaRepository;
	@Autowired
	OperaService operaService;
	@Autowired
	AutoreService autoreService;

	@GetMapping("/inserisciOpera")
	public String showForm(Model model, Opera opera,Autore autore) {
		List<Autore> autori = (List<Autore>)autoreService.findAll();
		if(autori.size()==0) {
			model.addAttribute("NoAutori","Non ci sono autori nel database, inseriscine uno");
            return "inserisciAutore";
		}
	return "inserisciOpera";
	}
	
	@PostMapping("/opera")
	public String addOpera(@Valid @ModelAttribute Opera opera, BindingResult bindingResult, Model model
			,@RequestParam("autoreId") Long id){
		
		if(bindingResult.hasErrors()){
			model.addAttribute("autori",autoreService.findAll());
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
