package sop.library.model.builder;

import java.util.ArrayList;
import java.util.List;

import sop.library.dal.dao.RoleDao;
import sop.library.dal.dao.RoleDaoImpl;
import sop.library.dal.entities.usermanagement.RoleEntity;
import sop.library.model.Role;
import sop.library.model.mapper.RoleMapper;

public class RoleModelBuilderImpl implements BaseModelBuilder<Role> {
	
	public List<Role> get(){
		List<Role> roles = new ArrayList<Role>();
		RoleDao roleDao = new RoleDaoImpl();
		for(RoleEntity role : roleDao.findAll()) {
			roles.add(RoleMapper.buildFromEntity(role));
		}
		return roles;
	}
	
	public Role get(Long id) {
		RoleDao roleDao = new RoleDaoImpl();
		RoleEntity role = roleDao.find(id);
		if(role == null)
			return null;
		return RoleMapper.buildFromEntity(role);
	}

	public Long save(Role userDto) {
		return null;
	}

	public void update(Long id, Role userDto) {
		
	}

	public void delete(Long id) {
		
	}

}