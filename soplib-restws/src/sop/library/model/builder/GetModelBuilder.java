package sop.library.model.builder;

import java.util.List;

public interface GetModelBuilder<T> {
	List<T> get();
	T get(Long id);
}