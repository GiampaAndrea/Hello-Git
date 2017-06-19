package it.uniroma3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Amministratore;
import it.uniroma3.repository.AmministratoreRepository;;

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
