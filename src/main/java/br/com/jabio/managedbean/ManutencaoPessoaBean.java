package br.com.jabio.managedbean;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import br.com.jabio.dao.PessoaDao;
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
	@Inject
	private PessoaDao pessoaDao;
	
	public void gravar(){
		pessoa = pessoaDao.gravar(pessoa);
		mensagensJsf.mensagemDeInformacao("Sucesso!", "Operação realizada com sucesso.");
		System.out.println(pessoa.getId());
	}
	
	public void novo(){
		pessoa = new Pessoa();
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
