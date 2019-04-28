package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Post")

@ManagedBean
@ViewScoped
public class Post {

	int postID = 0;
	
	@NotNull(message = "Please enter a post title. This is a required field.")
	@Size(min=2, max=50)
	String postTitle = "";
	
	@NotNull(message = "Please enter a blog description. This is a required field.")
	@Size(min=2, max=500)
	String postText = "";
	
	public Post() {
//		Do Something
	}
	
	public Post(int postID, String postTitle, String postText) {
		super();
		this.postID = postID;
		this.postTitle = postTitle;
		this.postText = postText;
	}

	public int getPostID() {
		return postID;
	}
	
	public void setPostID(int postID) {
		this.postID = postID;
	}
	
	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}
}
