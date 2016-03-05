package sop.lib.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sop.library.dal.dao.RoleDao;
import sop.library.dal.dao.RoleDaoImpl;
import sop.library.dal.entities.usermanagement.Role;


@WebService
public class UserService {

    public UserService() {}

    @WebMethod
    public String getRoleName(Long id) {
    	RoleDao roleDao = new RoleDaoImpl();
    	Role role = roleDao.find(id);
    	return role.getName();
    	
    	//return id.toString();
    }
}