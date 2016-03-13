package sop.library.model.builder;

import java.util.List;

import sop.library.exceptions.ResourceNotFoundException;

public interface BaseModelBuilder<T> {
	List<T> get();
	T get(Long id) throws ResourceNotFoundException;;
	Long save(T userDto);
	void update(Long id, T userDto) throws ResourceNotFoundException;
	void delete(Long id) throws ResourceNotFoundException;
}