package com.testeseas.entidade;

public class Pessoas {

	private int id;
	private String nome;
	private String cpf;
	private String cnh;
	
	public Pessoas () {
	}
	
	public int getId(){
		return id;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getCpf(){
		return cpf;
	} 
	
	public String getCnh(){
		return cnh;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setCpf(String cpf){
		this.cpf = cpf;
	} 
	
	public void setCnh(String cnh){
		this.cnh = cnh;
	}
	
}
