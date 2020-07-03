package com.sba.pm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sba.pm.dao.intf.IUserDao;
import com.sba.pm.entity.UserEntity;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public Integer saveOrUpadte(UserEntity userEntity) {
		Integer result = 0;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			session.saveOrUpdate(userEntity);
			result = 1;
			beginTransaction.commit();
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public UserEntity getUser(Integer id) {
		UserEntity user = null;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			user = (UserEntity) session.get(UserEntity.class, id);
			beginTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return user;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		List<UserEntity> results = new ArrayList<>();
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<UserEntity> createQuery = cb.createQuery(UserEntity.class);
			Root<UserEntity> root = createQuery.from(UserEntity.class);
			createQuery.orderBy(cb.desc(root.get("id")));
			createQuery.select(root);

			Query<UserEntity> query = session.createQuery(createQuery);
			results = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return results;
	}

	@Override
	public Integer deleteUser(Integer id) {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			UserEntity user = (UserEntity) session.get(UserEntity.class, id);
			session.delete(user);
			beginTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
