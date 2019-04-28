package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Post;

@RequestScoped
@Path("/posts")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class PostRestService {

		@Inject
		PostBusinessInterface service;
		
		//gets all posts and returns JSON data
		@GET
		@Path("/postsRest")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Post> getPostsAsJson() {
			List<Post> post = service.getPosts();
			
			if (post == null) {
				throw new RuntimeException("Posts were not found");
			}
			return service.getPosts();
		}
		
		//gets post by id and returns JSON data
		@GET
		@Path("/postsRest/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Post getPostByID(@PathParam("id") int id){
			Post post = service.findByID(id);
			if (post == null) {
				throw new RuntimeException("Post does not exist");
			}
			return post;
		}
		
		//creates a new post
		@POST
		@Path("/postsRest")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public boolean addPost(Post post) {
			if (post == null) {
				throw new RuntimeException("Post failed to create");
			}

			return service.create(post);
		}
		
		//gets all posts and returns XML data
		@GET
		@Path("/getxml")
		@Produces(MediaType.APPLICATION_XML)
		public Post[] getPostsAsXml() {
			List<Post> posts = service.getPosts();
			return posts.toArray(new Post[posts.size()]);	
		}
}
