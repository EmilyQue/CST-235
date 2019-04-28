package business;

import java.util.List;

import javax.ejb.Local;

import beans.Post;

@Local
public interface PostBusinessInterface {
	public List<Post> getPosts();
	public void setPosts(List<Post> posts);
	
	public List<Post>findAll();
	public Post findByID(int id);
	public boolean create(Post post);
	public boolean update(int id, Post post);
	public boolean delete(int id); 
}
