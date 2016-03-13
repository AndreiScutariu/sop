package sop.library.dal.entities;

import java.util.Date;

public interface BaseEntity {

	public Long getId();
	public void setId(Long id);
	
	public Date getCreatedDate();
	public void setCreatedDate(Date date);
	
	public Date getLastModifiedDate();
	public void setLastModifiedDate(Date date);
}
