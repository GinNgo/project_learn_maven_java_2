package vn.iotstar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;

import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;

import jakarta.persistence.criteria.Root;

import vn.iotstar.config.JPAConfig;
import vn.iotstar.dao.IEntityDao;

public abstract class AbstractEntityDao<T> implements IEntityDao<T> {

	private Class<T> entityClass;

	public AbstractEntityDao(Class<T> cls) {

		this.entityClass = cls;

	}

	@Override
	public void insert(T entity) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.persist(entity);

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

		}

		finally {

			enma.close();

		}

	}

	@Override
	public void update(T entity) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.merge(entity);

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

		}

		finally {

			enma.close();

		}

	}

//xóa entity thong qua biến id

	@Override
	public void delete(Object id) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			T entity = enma.find(entityClass, id);

			enma.remove(entity);

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

		}

		finally {

			enma.close();

		}

	}

	@Override
	public T findById(Object id) {

		EntityManager enma = JPAConfig.getEntityManager();

		T entity = enma.find(entityClass, id);

		return entity;

	}

	@Override
	public T findByName(String field, String name) {
		EntityManager enma = JPAConfig.getEntityManager();
		try {
			String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e." +field+" = :name";
			TypedQuery<T> query = enma.createQuery(jpql, entityClass);
			query.setParameter("name", name);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null; // không tìm thấy thì trả null
		} finally {
			enma.close();
		}
	}

	@Override
	@SuppressWarnings("unchecked")

	public List<T> findAll() {

		EntityManager enma = JPAConfig.getEntityManager();

		try {

//tạo truy vấn từ entity class

			CriteriaQuery<Object> cq = enma.getCriteriaBuilder().createQuery();

			cq.select(cq.from(entityClass));

			Query q = enma.createQuery(cq);

			return q.getResultList();

		} finally {

			enma.close();

		}

	}

	@Override
	public Long countAll() {

		EntityManager enma = JPAConfig.getEntityManager();

		try {

//tạo truy vấn từ entity class

			CriteriaQuery<Object> cq = enma.getCriteriaBuilder().createQuery();

			Root<T> rt = cq.from(entityClass);

			cq.select(enma.getCriteriaBuilder().count(rt));

			Query q = enma.createQuery(cq);

			return (Long) q.getSingleResult();

		} finally {

			enma.close();

		}

	}

	@Override
	@SuppressWarnings("unchecked")

	public List<T> findAll(boolean all, int firstResult, int maxResult) {

		EntityManager enma = JPAConfig.getEntityManager();

		try {

//tạo truy vấn từ entity class

			CriteriaQuery<Object> cq = enma.getCriteriaBuilder().createQuery();

			cq.select(cq.from(entityClass));

			Query q = enma.createQuery(cq);

			if (!all) {

				q.setFirstResult(firstResult);

				q.setMaxResults(maxResult);

			}

			return q.getResultList();

		} finally {

			enma.close();

		}

	}

	@Override
	public boolean checkExist(String field, Object value) {
		EntityManager enma = JPAConfig.getEntityManager();
		try {
			// Kiểm tra tránh SQL injection bằng cách chỉ chấp nhận tên field hợp lệ
			// Fen có thể bỏ phần này nếu chắc chắn chỉ dùng field cố định
			if (field == null || field.isBlank()) {
				throw new IllegalArgumentException("Field name cannot be null or blank");
			}

			String jpql = "SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e WHERE e." + field + " = :value";
			Long count = enma.createQuery(jpql, Long.class).setParameter("value", value).getSingleResult();
			return count > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			enma.close();
		}
	}

}