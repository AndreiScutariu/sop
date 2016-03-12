package sop.library.api.rest;

import javax.ws.rs.Path;

import sop.library.api.base.GetApi;
import sop.library.model.User;
import sop.library.model.builder.UserModelBuilderImpl;

@Path("users")
public class Users extends GetApi<User>{

	public Users() {
		modelBuilder = new UserModelBuilderImpl();
	}
	
}