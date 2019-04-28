 package business;

//import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.User;
import data.UserDataService;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(UserBusinessInterface.class)
@Alternative
public class UserBusinessService implements UserBusinessInterface {

	@EJB
	UserDataService service;
	
	    /**
     * Default constructor. 
     */
	public UserBusinessService() {
		//
	}
	
	//test method
    @Override
    public void test() {
    	System.out.println("=======> Hello from OrdersBusinessService.test()");
    }

    //method to get all users
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	//method to set users in list
	@Override
	public void setUsers(List<User> users) {
		// TODO Auto-generated method stub
//		this.orders = orders;
	}
	
	//method to find user by username
	@Override
	public boolean findByUsername(User user) {
		return service.findByUsername(user);
	}
	
	//method to create a new user
	@Override
	public boolean create(User user) {
		return service.create(user);
	}
	
}
