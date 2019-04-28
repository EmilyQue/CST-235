package beans;
import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
public class User {
	
	public User() {
//		Do Something
	}
	
	public User(String firstName, String lastName, String email, int phone, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}
	
	@PostConstruct
	public void init() {
		//get logged in principle
		Principal principle = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		if (principle == null) {
			setFirstName("Unknown");
			setLastName("");
		}
		
		else {
			setFirstName(principle.getName());
			setLastName("");
		}
	}
	
	@NotNull(message = "Please enter your first name. This is a required field.")
	@Size(min=2, max=50)
	String firstName = "";
	
	@NotNull(message = "Please enter your last name. This is a required field.")
	@Size(min=2, max=50)
	String lastName = "";
	
	@NotNull(message = "Please enter your email. This is a required field.")
	@Size(min=2, max=50)
	String email = "";
	
	@NotNull(message = "Please enter your phone number. This is a required field.")
	int phone;
	
	@NotNull(message = "Please enter your username. This is a required field.")
	@Size(min=2, max=50)
	String username = "";
	
	@NotNull(message = "Please enter your password. This is a required field.")
	@Size(min=2, max=50)
	String password = "";

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}