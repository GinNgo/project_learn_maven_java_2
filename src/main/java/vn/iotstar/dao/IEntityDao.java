package vn.iotstar.dao;

import java.util.List;

public interface IEntityDao<T> {

	boolean checkExist(String field, Object value);

	List<T> findAll(boolean all, int firstResult, int maxResult);

	Long countAll();

	List<T> findAll();

	T findById(Object id);

	void delete(Object id);

	void update(T entity);

	void insert(T entity);

	T findByName(String field, String name);

}
