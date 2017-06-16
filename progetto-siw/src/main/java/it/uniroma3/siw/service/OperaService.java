package it.uniroma3.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Opera;
import it.uniroma3.repository.OperaRepository;

/* Dal nostro modello di dominio l'opera deve poter essere salvata e cancellata */
@Service
public class OperaService {
	
	@Autowired
	OperaRepository operaRepository;
	
	@Transactional
	public Opera addOpera(Opera opera){
		return this.operaRepository.save(opera);
	}
	
	@Transactional
	public void deleteOpera(Opera opera){
		this.operaRepository.delete(opera);
	}
	
	public Iterable<Opera> findAll(){
		return this.operaRepository.findAll();
	}
	
	public Opera findOne(Long id){
		return this.operaRepository.findOne(id);
	}

}
