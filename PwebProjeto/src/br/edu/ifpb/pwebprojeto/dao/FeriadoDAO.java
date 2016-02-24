package br.edu.ifpb.pwebprojeto.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.pwebprojeto.model.Feriado;

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
