package sop.library.dal.dao;

import java.util.List;

import sop.library.dal.entities.BaseEntity;

public interface BaseDao<T extends BaseEntity> {

	public abstract Long saveOrUpdate(T obj);

	public abstract T find(Long id);

	public abstract List<T> findAll();

	public abstract void delete(T obj);

}