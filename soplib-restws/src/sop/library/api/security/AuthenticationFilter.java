package sop.library.api.security;

import java.io.IOException;

import java.lang.reflect.Method;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
//import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticationFilter implements
		javax.ws.rs.container.ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";

//	private static final Response ACCESS_DENIED = Response
//			.status(Response.Status.UNAUTHORIZED)
//			.entity("You cannot access this resource.").build();

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		Method method = resourceInfo.getResourceMethod();

		if (!method.isAnnotationPresent(PermitAll.class)) {
			final MultivaluedMap<String, String> headers = requestContext.getHeaders();
			final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);
			if (authorization == null || authorization.isEmpty()) {
				//requestContext.abortWith(ACCESS_DENIED);
				return;
			}
			
			String content = authorization.get(0);
			content = content.replace(AUTHENTICATION_SCHEME, "");
			
			if(method.isAnnotationPresent(RolesAllowed.class)) {
				
			}
		}
	}	

}
