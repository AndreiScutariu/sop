package sop.library;

import sop.library.dal.dao.RoleDao;
import sop.library.dal.dao.RoleDaoImpl;
import sop.library.dal.entities.usermanagement.Role;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RoleDaoTest extends TestCase
{
	RoleDao roleDao = new RoleDaoImpl();
	
    public RoleDaoTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( RoleDaoTest.class );
    }
    
    public void testInsert()
    {
    	Role role = new Role();
    	role.setName("Manager");
    	
    	roleDao.saveOrUpdate(role);
    	
        assertTrue( role.getId() > 0 );
        
        roleDao.delete(role);
    }
    
    public void testDelete()
    {
    	Role role = new Role();
    	role.setName("Manager");
    	
    	Long id = roleDao.saveOrUpdate(role);

    	roleDao.delete(role);
        
        Role newRole = roleDao.find(id);
		assertTrue( newRole == null );
    }
}
