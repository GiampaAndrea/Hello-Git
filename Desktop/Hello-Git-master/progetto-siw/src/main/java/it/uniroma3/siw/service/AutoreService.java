package it.uniroma3.siw.service;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Autore;

import it.uniroma3.siw.repository.AutoreRepository;

/* Dal nostro modello di dominio ci può essere la consultazione dell'autore e l'update. MANCA L'UPDATE. */
@Service
public class AutoreService {
	
	@Autowired
	AutoreRepository autoreRepository;
	
	@Transactional
	public void addAutore(final Autore autore){
		 this.autoreRepository.save(autore);
	}
	
	public Iterable<Autore> findAll(){
		return this.autoreRepository.findAll();
	}
	
	public Autore findOne(Long id){
		return this.autoreRepository.findOne(id);
	}
	
	public void elimina(Autore autore){
		autoreRepository.delete(autore);
	}

	public List<Autore> fingByCognome(String cognome){
		return this.autoreRepository.findByCognome(cognome);			
	}
	
	public List<Autore> fingByNazionalita(String nazionalita){
		return this.autoreRepository.findByNazionalita(nazionalita);			
	}

}
