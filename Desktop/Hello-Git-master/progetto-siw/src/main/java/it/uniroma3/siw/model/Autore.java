package it.uniroma3.siw.model;

import java.util.ArrayList;


import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Autore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String cognome;
	@NotNull
	private String nazionalita;
	
	@NotNull
	private Integer dataNascita;
	
	@NotNull
	private Integer dataMorte;
	
	 @OneToMany(mappedBy = "autore", cascade=CascadeType.REMOVE)
	 List<Opera> opere;
	 
	 protected Autore(){
		 this.opere=new ArrayList<>();
	 }
	 public Autore(String nome,String cognome, String nazionalita, Integer dataNascita,Integer dataMorte){
		 this.nome=nome;
		 this.cognome=cognome;
		 this.nazionalita=nazionalita;
		 this.dataMorte=dataMorte;
		 this.dataNascita=dataNascita;
		 
	 }
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getNazionalita() {
		return nazionalita;
	}
	
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	
	public Integer getDataNascita() {
		return dataNascita;
	}
	
	public void setDataNascita(Integer dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	public Integer getDataMorte() {
		return dataMorte;
	}
	
	public void setDataMorte(Integer dataMorte) {
		this.dataMorte = dataMorte;
	}

	public List<Opera> getOpere() {
		return opere;
	}

	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}

}
