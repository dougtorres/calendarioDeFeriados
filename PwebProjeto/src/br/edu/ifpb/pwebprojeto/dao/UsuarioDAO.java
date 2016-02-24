package br.edu.ifpb.pwebprojeto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.pwebprojeto.model.Nota;
import br.edu.ifpb.pwebprojeto.model.Usuario;

public class UsuarioDAO extends DAO<Usuario>{

	@Override
	public Usuario read(Object chave) throws Exception {
		try{
			Query q = manager.createQuery("select u from Usuario u where u.id = '"+chave+"' ");
			Usuario u = (Usuario) q.getSingleResult();
			return u;
		}catch(NoResultException e){
			return null;
		}
	}
	
	public Usuario getUsuarioByLogin(String login, String senha){
		try{
			Query q = manager.createQuery("select u from Usuario u where u.login = '"+login+"' AND u.senha = '"+senha+"' ");
			Usuario u = (Usuario) q.getSingleResult();
			return u;
		}catch(NoResultException e){
			return null;
		}
	}
	
	public ArrayList<Nota> getNota(String descricao, String data){
		try{
			Query q = manager.createQuery("select n from Nota n where n.title = '"+descricao+"' AND n.date = '"+data+"'");
			ArrayList<Nota> aux = (ArrayList<Nota>) q.getResultList();
			return aux;
		}catch(NoResultException e){
			return null;
		}
	}
	
	
	public List<Usuario> readAllUserInactive(){
		try{
			Query q = manager.createQuery("select u from Usuario u where u.status = 'false' ");
			List<Usuario> list = (List<Usuario>) q.getResultList();
			return list;
		}catch(NoResultException e){
			return null;
		}
	}

}

