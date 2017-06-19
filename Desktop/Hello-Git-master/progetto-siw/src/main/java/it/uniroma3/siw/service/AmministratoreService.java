package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Amministratore;
import it.uniroma3.siw.repository.AmministratoreRepository;;

@Service
public class AmministratoreService {
	
	@Autowired
	AmministratoreRepository amministratoreRepository;
	
	public Iterable<Amministratore> findAll(){
		return this.amministratoreRepository.findAll();
	}
	
	public Amministratore findOne(Long id){
		return this.amministratoreRepository.findOne(id);
	}

	
}
