package br.edu.ifpb.projetopwebii.model;

import javax.persistence.Entity;

@Entity
public class Admin extends Usuario{

	public Admin(){}
	
	public Admin (String nome, String login, String senha){
		super(nome,login,senha);
		super.setAdmin(true);
		
	}


	
	
}
