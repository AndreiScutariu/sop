package sop.library.model.mapper;

import java.util.List;

public interface Mapper<TModel, TEntity> {
	
	public TModel toModel(TEntity entity);
	
	public List<TModel> toModelList(List<TEntity> entities);
	
	public TEntity toEntity(TModel dto);
	
	public List<TEntity> toEntityList(List<TModel> dtos);
}
