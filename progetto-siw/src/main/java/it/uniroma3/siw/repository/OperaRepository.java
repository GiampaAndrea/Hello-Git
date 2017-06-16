package it.uniroma3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.model.Autore;
import it.uniroma3.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long>{
	
	void addByTitolo(String titolo);
	
	void deleteByTitolo(String titolo);
	
	List<Opera> findByTitolo(String titolo);
	
	List<Opera> findByAnno(Integer anno);
	
	List<Opera> findByAutore(Autore autore);

}
