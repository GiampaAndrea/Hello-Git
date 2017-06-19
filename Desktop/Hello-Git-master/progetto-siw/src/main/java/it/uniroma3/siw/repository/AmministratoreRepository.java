package it.uniroma3.siw.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Amministratore;

public interface AmministratoreRepository extends CrudRepository<Amministratore, Long>{
	
	List<Amministratore> findByUsername(String username);
	
	List<Amministratore> findByNome(String nome);
	
	List<Amministratore> findByCognome(String cognome);

}
