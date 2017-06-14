package it.uniroma3.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Opera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String titolo;
	
	@NotNull
	private Integer anno;
	
	private String tecnica;
	private String dimensioni;
	
	@NotNull
	@ManyToOne
	private Autore autore;
	
	public Opera(String titolo, Integer anno, Autore autore){
		this.titolo = titolo;
		this.anno = anno;
		this.autore = autore;
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

	public String getDimensioni() {
		return dimensioni;
	}

	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	
	

}
