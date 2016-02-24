package br.edu.ifpb.pwebprojeto.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hsqldb.lib.Iterator;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String login;
	private String senha;
	private boolean admin;
	@OneToMany(cascade = CascadeType.ALL)
	 @ElementCollection(targetClass=Nota.class)
	private List<Nota> notas;
	
	
	public Usuario(){}

	public Usuario(String nome, String login, String senha) {

		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.admin = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	
	public void addNota(String descricao, String data) throws ParseException{
		Nota n = new Nota(descricao, data);
		this.notas.add(n);
	}
	
	public void removerNota(int id){
		
		Iterator in = (Iterator) this.notas.iterator();
		
		while(in.hasNext()){
			Nota n = (Nota) in.next();
			if(n.getId() == id){
				this.notas.remove(n);
			}
			
		}
	}

	public void alterarNota(int id, String descricao, String data) throws ParseException{
		
		java.util.Iterator<Nota> in = this.notas.iterator();
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); 
		Date dataAux = sdf1.parse(data);
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy/MM/dd"); 
		while(in.hasNext()){
			Nota n = (Nota) in.next();
			if(n.getId() == id){
				n.setText(descricao);
				n.setDate(sdf2.format(dataAux));
				this.notas.set(id, n);
			}
			
		}
	}
	
	public Nota getNotaById(int id){
		
		Iterator in = (Iterator) this.notas.iterator();
		while(in.hasNext()){
			Nota n = (Nota) in.next();
			if(n.getId() == id){
			
				return n;
			}
			
		}
		
		return null;
	}
	
	
	
}
