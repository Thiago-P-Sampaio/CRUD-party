package com.festa.api.Model;

import java.util.UUID;

import com.festa.api.DTO.FestaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table (name ="festa")
@AllArgsConstructor
@NoArgsConstructor
public class FestaModel {

	@Id @GeneratedValue (strategy = GenerationType.UUID)
	private UUID id;
	private String nome;
	private String presente;
	
	public FestaModel() {
		
	}
	
	public FestaModel(UUID id, String nome, String Presente) {
		this.id=id;
		this.nome=nome;
		this.presente=presente;
		
	}
	
	public FestaModel(FestaDTO dto) {
	this.nome = dto.nome();	
	this.presente = dto.presente();	
	}
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPresente() {
		return presente;
	}
	public void setPresente(String presente) {
		this.presente = presente;
	}
	
	

}
