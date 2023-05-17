package com.dalila_jose.helpdesk.domain.dtos;

//essa classe só faz a conversão de usuario e senha que vem na requisição de login 
public class CredenciaisDTO {
	
	private String email;
	private String senha;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
