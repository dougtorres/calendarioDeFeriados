package br.edu.ifpb.projetopwebii.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.projetopwebii.model.Feriado;

public class FeriadoDAO extends DAO<Feriado>{
	
	@Override
	public Feriado read(Object chave) throws Exception {
		try{
			Query q = manager.createQuery("select f from Feriado f where f.id = '"+chave+"' ");
			Feriado f = (Feriado) q.getSingleResult();
			return f;
		}catch(NoResultException e){
			return null;
		}
	}
	


}
