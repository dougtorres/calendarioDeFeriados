package br.edu.ifpb.pwebprojeto.dao;

public interface DAOInterface<T> {
	public void create(T obj);
	public T read(Object obj) throws Exception;
	public T update(T obj);
	public void delete(T obj);
	public void refresh(T obj);
}
