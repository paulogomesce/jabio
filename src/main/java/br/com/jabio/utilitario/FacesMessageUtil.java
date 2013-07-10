package br.com.jabio.utilitario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

@Component
public class FacesMessageUtil {
	
	public void mensagemDeErro(String detalhe, String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, detalhe, mensagem));
	}
	
	public void mensagemDeErroFatal(String detalhe, String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, detalhe, mensagem));
	}

	public void mensagemDeAlerta(String detalhe, String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, detalhe, mensagem));
	}
	
	public void mensagemDeInformacao(String detalhe, String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, detalhe, mensagem));
	}

}
