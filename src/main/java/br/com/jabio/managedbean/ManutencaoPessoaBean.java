package br.com.jabio.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Scope;

import br.com.jabio.modelo.Pessoa;

@Named
@Scope("session")
public class ManutencaoPessoaBean implements Serializable{

	private static final long serialVersionUID = 1L;	
	private Pessoa pessoa = new Pessoa();
	
	public void gravar(ActionEvent e){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexao.jpa.postgres");
		EntityManager em = factory.createEntityManager();		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"teste", "teste"));
	}	
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
