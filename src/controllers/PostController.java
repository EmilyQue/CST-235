package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Post;
import business.PostBusinessInterface;

@ManagedBean
@ViewScoped
public class PostController {

	@Inject 
	PostBusinessInterface service;
	
	//method to create post
	public String onSubmit(Post post) {
		service.create(post);
		
		//put the user object into the POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("post", post);
		
		//return response view
		return "Response.xhtml";
	}
	
	//method to return post form when clicking create button
	public String showAddPost(Post post) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("post", post);
		return "PostForm.xhtml";
	}
	
	//method to show the individual post info when link is clicked
	public String showPost(Post post) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("post", post);
		return "BlogPost.xhtml";
	}
	
	//method to show all posts and display into data table
	public String showAllPosts(Post post) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("post", post);
		return "Response.xhtml";
	}
	
	//finds each post based on id
	public String findPost(Post post) {
		service.findByID(post.getPostID());
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("post", post);
		
		return "Response.xhtml";
	}

	//method to delete post
	public String onDelete(Post post) {
		service.delete(post.getPostID());
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("post", post);
		
		return "Response.xhtml";
	}
	
	//method to edit post
	public String onEdit(Post post) {
		service.update(post.getPostID(), post);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("post", post);
		return "Response.xhtml";
	}
	
	//returns the edit form when clicking the edit button
	public String showEdit(Post post) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("post", post);
		return "EditPostForm.xhtml";
	}
	
	//gets the service from the post business interface
	public PostBusinessInterface getService() {
		return service;
	}
}
