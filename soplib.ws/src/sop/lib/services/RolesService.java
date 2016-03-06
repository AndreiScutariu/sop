package sop.lib.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sop.lib.dto.RoleDto;
import sop.lib.mappers.RoleMapper;
import sop.library.dal.dao.RoleDao;
import sop.library.dal.dao.RoleDaoImpl;
import sop.library.dal.entities.usermanagement.Role;

@WebService
public class RolesService {

    public RolesService() {}

    /*
    @WebMethod
    public RoleDto get(Long id) {
    	RoleDao roleDao = new RoleDaoImpl();
    	Role role = roleDao.find(id);
    	return RoleMapper.buildFromEntity(role);
    }
    */
    
    @WebMethod
    public List<RoleDto> getList() {
    	RoleDao roleDao = new RoleDaoImpl();
    	List<Role> roles = roleDao.findAll();
    	return RoleMapper.buildFromEntities(roles);
    }
}