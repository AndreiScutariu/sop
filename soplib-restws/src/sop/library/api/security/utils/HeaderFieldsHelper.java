package sop.library.api.security.utils;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import sop.library.exceptions.AuthTokenNotPresentException;

public class AuthHeaderToken {
	public static String getToken(MultivaluedMap<String, String> headers) throws AuthTokenNotPresentException {
		final String AUTHORIZATION_PROPERTY = "Authorization";
		final String AUTHENTICATION_SCHEME = "Basic";
		final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);
		if (authorization == null || authorization.isEmpty()) {
			throw new AuthTokenNotPresentException();
		}
		String content = authorization.get(0);
		content = content.replace(AUTHENTICATION_SCHEME, "");
		return content;
	}
}
