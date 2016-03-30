package sop.library.api.security;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import sop.library.api.security.utils.HeaderFieldsHelper;
import sop.library.exceptions.AuthTokenNotPresentException;
import sop.library.utils.Console;

@Provider
public class AuthenticationFilter implements
		javax.ws.rs.container.ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

//	private static final Response ACCESS_DENIED = Response
//			.status(Response.Status.UNAUTHORIZED)
//			.entity("You cannot access this resource. Please provide a valid token.")
//			//.header("Access-Control-Allow-Origin", "*")
//			.build();

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		Method method = resourceInfo.getResourceMethod();
		if (!method.isAnnotationPresent(PermitAll.class)) {
			String authToken = null;
			
			try {
				authToken = HeaderFieldsHelper.getToken(requestContext);
			} catch (AuthTokenNotPresentException e) {
				//requestContext.abortWith(ACCESS_DENIED);
			}
			//TODO Test expired tokens
			
			Console.log("Token: " + authToken);
			
			if (method.isAnnotationPresent(RolesAllowed.class)) {
				RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
                Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));
                for(String s : rolesSet) {
                	System.out.println(s);
                }
			}
		}
	}
}