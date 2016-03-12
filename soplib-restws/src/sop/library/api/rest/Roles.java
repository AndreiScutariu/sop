package sop.library.api.rest;

import javax.ws.rs.Path;

import sop.library.api.base.GetApi;
import sop.library.model.Role;
import sop.library.model.builder.RoleModelBuilderImpl;

@Path("roles")
public class Roles extends GetApi<Role> {

	protected Roles() {
		modelBuilder = new RoleModelBuilderImpl();
	}
	
}
