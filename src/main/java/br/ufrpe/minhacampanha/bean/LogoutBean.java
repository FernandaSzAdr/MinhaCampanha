package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@ManagedBean 
@SessionScoped
public class LogoutBean implements Serializable{
	private FacesContext context = FacesContext.getCurrentInstance();
	
	public String logout(){
		String page = "";
		
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.invalidate(); 
	
		page = "/pages/login?faces-redirect=true";
		return page;
	}
	
}
