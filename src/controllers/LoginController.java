package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.UserBusinessInterface;

@ManagedBean
@ViewScoped
public class LoginController {
	
	@Inject
	UserBusinessInterface service;
	
	public LoginController() {
		//
	}
	
	//takes user to response page once they have logged in
	public String onSubmit() {
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);

		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		return "Response.xhtml";
	}
	
	//logout method
	public String onLogoff() {
		//invalidate the session to clear security token
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		//redirect to protected page to get login page
		return "Response.xhtml?faces-redirect=true";
	}
	
	public UserBusinessInterface getService() {
		return service;
	}
}
