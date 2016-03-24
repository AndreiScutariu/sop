package sop.library.model;

import java.util.Date;

public class TokenResponse {

	private String token;

	private Date expireAt;

	public TokenResponse() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}

}
