package br.edu.ifpb.pwebprojeto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.pwebprojeto.model.Nota;
import br.edu.ifpb.pwebprojeto.model.Usuario;

public class NotaDAO extends DAO<Nota>{
	

		@Override
		public Nota read(Object chave) throws Exception {
			try{
				Query q = manager.createQuery("select n from Nota n where n.id = '"+chave+"' ");
				Nota n  = (Nota) q.getSingleResult();
				return n;
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
		



}
