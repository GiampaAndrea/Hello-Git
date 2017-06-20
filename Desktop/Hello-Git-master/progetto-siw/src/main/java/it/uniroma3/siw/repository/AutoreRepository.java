package it.uniroma3.siw.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Autore;

public interface AutoreRepository extends CrudRepository<Autore, Long>{
	
	List<Autore> findByNome(String nome);
	
	List<Autore> findByCognome(String cognome);
	
	List<Autore> findByDataNascita(Integer dataNascita);
	
	List<Autore> findByNazionalita(String nazionalita);

	
	

}
