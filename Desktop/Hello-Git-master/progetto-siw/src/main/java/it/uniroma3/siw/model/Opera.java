package it.uniroma3.siw.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Opera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String titolo;
	
	@NotNull
	private Integer anno;
	
	private String tecnica;
	private String dimensione;
	
	@NotNull
	@ManyToOne
	private Autore autore;
	
	public Opera() {
		
	}
	
	public Opera(String titolo, Integer anno, String dimensione,String tecnica){
		this.titolo = titolo;
		this.anno = anno;
		this.dimensione = dimensione;
		this.tecnica = tecnica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public String getDimensione() {
		return dimensione;
	}

	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	
	

}
