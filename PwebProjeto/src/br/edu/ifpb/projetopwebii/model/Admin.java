package br.edu.ifpb.projetopwebii.model;

import javax.persistence.Entity;

@Entity
public class Admin extends Usuario{

	private boolean admin;
	
	
	public Admin (String nome, String login, String senha){
		super(nome,login,senha);
		this.admin = true;
		
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	
}
