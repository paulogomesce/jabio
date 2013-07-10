package br.com.jabio.dao.implementacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jabio.dao.PessoaDao;
import br.com.jabio.modelo.Pessoa;

@Repository
@Transactional(readOnly = true)
public class PessoaDaoImpl implements PessoaDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Pessoa gravar(Pessoa pessoa) {
		return entityManager.merge(pessoa);
	}

	public Pessoa remover(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	public Pessoa pesquisarPorId(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Pessoa> listarTudo() {
		// TODO Auto-generated method stub
		return null;
	}

}
