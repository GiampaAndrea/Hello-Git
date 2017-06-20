package it.uniroma3.siw.controller;






import javax.validation.Valid;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.repository.AutoreRepository;
import it.uniroma3.siw.service.AutoreService;


@Controller
public class AutoreController {

	@Autowired
	AutoreRepository autoreRepository;
	AutoreService autoreService;
	
	
	
	@GetMapping("/inserisciAutore")
	public String showForm(Autore autore) {
	return "inserisciAutore";
	}
	
	@PostMapping("/autore")
    public String addAutore(@Valid @ModelAttribute Autore autore, 
    									BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return showForm(autore);
        }
        model.addAttribute(autore);
        autoreRepository.save(autore);
        return "risultatoAutore";
    }
	

	@GetMapping("/listaAutore")
	public String getAllAutori(Model model){
		model.addAttribute("autori", this.autoreService.findAll());
		return "listaAutore";
	}
	@RequestMapping(value="/eliminaautore", method = RequestMethod.GET)
	public String eliminaAutore(@RequestParam("id") Long id, Model model) {
		Autore autore= autoreService.findOne(id);
		autoreService.elimina(autore);
		model.addAttribute("autori",autoreService.findAll());
		return "listaAutore";
	}
	

}
