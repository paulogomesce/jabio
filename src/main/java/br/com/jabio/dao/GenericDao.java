package br.com.jabio.dao;

import java.util.List;

public interface GenericDao<T> {
	
	public T gravar(T entidade);
	public T remover(T entidade);
	public T pesquisarPorId(Object id);
	public List<T> listarTudo();

}
