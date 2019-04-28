package business;

//import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Post;
import data.PostDataService;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(PostBusinessInterface.class)
@Alternative
public class PostBusinessService implements PostBusinessInterface {

	@EJB
	PostDataService service;
	
	public PostBusinessService() {
		//
	}

	//method to get all posts
	@Override
	public List<Post> getPosts() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	//method to set posts into list
	@Override
	public void setPosts(List<Post> posts) {
		// TODO Auto-generated method stub
//		this.orders = orders;
	}
	
	@Override
	//method to find post by id
	public Post findByID(int id) {
		return service.findByID(id);
	}
	
	@Override
	//method to find all posts
	public List<Post>findAll() {
		return service.findAll();
	}
	
	@Override
	//method to create a post
	public boolean create(Post post) {
		return service.create(post);
	}
	
	@Override
	//method to update post 
	public boolean update(int id, Post post) {
		return service.update(id, post);
	}
	
	@Override
	//method to delete post by id
	public boolean delete(int id) {
		return service.delete(id);
	}

}
