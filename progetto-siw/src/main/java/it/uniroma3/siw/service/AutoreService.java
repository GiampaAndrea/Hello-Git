package it.uniroma3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Autore;
import it.uniroma3.repository.AutoreRepository;

/* Dal nostro modello di dominio ci può essere la consultazione dell'autore e l'update. MANCA L'UPDATE. */
@Service
public class AutoreService {
	
	@Autowired
	AutoreRepository autoreRepository;
	
	public Iterable<Autore> findAll(){
		return this.autoreRepository.findAll();
	}
	
	public Autore findOne(Long id){
		return this.autoreRepository.findOne(id);
	}

}
