package sop.library.api.security;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import sop.library.api.security.utils.AuthHeaderToken;
import sop.library.exceptions.AuthTokenNotPresentException;

@Provider
public class AuthenticationFilter implements
		javax.ws.rs.container.ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	private static final Response ACCESS_DENIED = Response
			.status(Response.Status.UNAUTHORIZED)
			.entity("You cannot access this resource. Please provide a valid token.").build();

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		Method method = resourceInfo.getResourceMethod();
		if (!method.isAnnotationPresent(PermitAll.class)) {
			String content = null;
			
			try {
				content = AuthHeaderToken.getToken(requestContext.getHeaders());
			} catch (AuthTokenNotPresentException e) {
				requestContext.abortWith(ACCESS_DENIED);
			}
			
			if (method.isAnnotationPresent(RolesAllowed.class)) {
				System.out.println("Filter Token: " + content);
			}
		}
	}
}
