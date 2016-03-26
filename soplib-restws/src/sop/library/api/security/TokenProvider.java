package sop.library.api.security;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import sop.library.dal.dao.UserDao;
import sop.library.dal.dao.UserDaoImpl;
import sop.library.dal.dao.UserTokenDao;
import sop.library.dal.dao.UserTokenDaoImpl;
import sop.library.dal.entities.usermanagement.UserEntity;
import sop.library.dal.entities.usermanagement.UserToken;
import sop.library.model.TokenRequest;
import sop.library.model.TokenResponse;

@Path("generatetoken")
public class TokenProvider {
	
	public TokenProvider() {
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response generateToken(TokenRequest tokenRequest) {
		
		//TODO Refactor, move this to model builders :)
		UserDao userDao = new UserDaoImpl();
		UserTokenDao tokenDao = new UserTokenDaoImpl();
		
		UserEntity userEntity = userDao.getByEmail(tokenRequest.getEmail());		
		if(userEntity == null)
			return Response.status(Status.NOT_FOUND).build();
			
		UserToken token = new UserToken();
		token.setUser(userEntity);
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(UUID.randomUUID().toString().replace("-", ""));
		stringBuilder.append(UUID.randomUUID().toString().replace("-", ""));
		stringBuilder.append(UUID.randomUUID().toString().replace("-", ""));
		token.setToken(stringBuilder.toString());
		
		Long id = tokenDao.saveOrUpdate(token);
		token = tokenDao.find(id);
		
		TokenResponse response = new TokenResponse();
		response.setToken(token.getToken());
		response.setExpireAt(token.getExpireAt());
		
		return Response.ok().entity(response).build();
	}
}
