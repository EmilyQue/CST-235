package business;

import java.util.List;

import javax.ejb.Local;
import beans.User;

@Local
public interface UserBusinessInterface {

	public void test();
	public List<User> getUsers();
	public void setUsers(List<User> users);
	
	public boolean findByUsername(User user);
	public boolean create(User user);
}
