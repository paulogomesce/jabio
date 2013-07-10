package br.com.jabio.managedbean;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Scope;

import br.com.jabio.modelo.Pessoa;
import br.com.jabio.utilitario.FacesMessageUtil;

@Named
@Scope("request")
public class ManutencaoPessoaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pessoa pessoa;	
	@Inject
	private FacesMessageUtil mensagensJsf;
	
	public void gravar(){
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexao.jpa.postgres");
			EntityManager em = factory.createEntityManager();
			
			em.getTransaction().begin();
			em.merge(pessoa);
			em.getTransaction().commit();
			pessoa = null;
			mensagensJsf.mensagemDeInformacao("Sucesso", "Operação realizada com sucesso.--");
		}catch(Exception e){
			mensagensJsf.mensagemDeErroFatal("Erro", e.getMessage());
		}
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
