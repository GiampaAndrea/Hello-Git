package it.uniroma3.siw.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Opera;
import it.uniroma3.siw.repository.OperaRepository;

/* Dal nostro modello di dominio l'opera deve poter essere salvata e cancellata */
@Service
public class OperaService {
	
	@Autowired
	OperaRepository operaRepository;
	
	@Transactional
	public void addOpera(Opera opera){
		 this.operaRepository.save(opera);
	}
	
	
	public void deleteOpera(Long id){
		this.operaRepository.delete(id);
	}
	
	public Iterable<Opera> findAll(){
		return this.operaRepository.findAll();
	}
	
	public Opera findOne(Long id){
		return this.operaRepository.findOne(id);
	}

}
