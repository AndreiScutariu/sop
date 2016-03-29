package sop.library.api.security.utils;

import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.MultivaluedMap;

import sop.library.exceptions.AuthTokenNotPresentException;

public class HeaderFieldsHelper {
	final static String AUTHORIZATION_PROPERTY = "Authorization";
	final static String AUTHENTICATION_SCHEME = "Basic";
	public static String getToken(ContainerRequestContext requestContext) throws AuthTokenNotPresentException {
		MultivaluedMap<String, String> headers = requestContext.getHeaders();
		final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);
		if (authorization == null || authorization.isEmpty()) {
			throw new AuthTokenNotPresentException();
		}
		String content = authorization.get(0);
		content = getToken(content);
		return content;
	}

	public static String getToken(String content) {
		content = content.replace(AUTHENTICATION_SCHEME, "");
		return content;
	}
}
