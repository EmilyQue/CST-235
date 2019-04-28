package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.UserBusinessInterface;

@ManagedBean
@ViewScoped
public class RegisterController {

	@Inject
	UserBusinessInterface service;
	
	//creates user during registration
	public String onSubmit(User user) {
		service.create(user);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		return "RegisterSuccess.xhtml";
	}
	
	public UserBusinessInterface getService() {
		return service;
	}
}
