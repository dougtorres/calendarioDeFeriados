package br.edu.ifpb.projetopwebii.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.projetopwebii.model.Usuario;

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

