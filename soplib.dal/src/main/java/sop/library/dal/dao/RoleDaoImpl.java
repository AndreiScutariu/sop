package sop.library.dal.dao;

import sop.library.dal.entities.usermanagement.RoleEntity;

public class RoleDaoImpl extends BaseDaoImpl<RoleEntity> implements RoleDao {

	public RoleDaoImpl() {
		super(RoleEntity.class);
    }

}
