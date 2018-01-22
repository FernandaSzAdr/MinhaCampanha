package br.ufrpe.minhacampanha.bean;

import javax.faces.bean.ManagedBean;
import org.omnifaces.util.Messages;

@ManagedBean 
public class LoginBean {
	
	public void logar(){
		Messages.addGlobalInfo("Login realizado com sucesso!");
		/*String texto = "Login realizado com sucesso!";
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto);
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, mensagem);*/
	}
	
	public void criarConta(){
		Messages.addGlobalInfo("Conta criada com sucesso!");
	}
}
