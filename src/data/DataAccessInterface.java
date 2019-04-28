package data;

import java.util.List;

import javax.ejb.Local;

@Local
public interface DataAccessInterface <Post> {

	public List<Post>findAll();
	public Post findByID(int id);
	public boolean create(Post post);
	public boolean update(int id, Post post);
	public boolean delete(int id); 
}