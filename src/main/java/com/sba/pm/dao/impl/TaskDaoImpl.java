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

import com.sba.pm.dao.intf.ITaskDao;
import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.entity.TaskEntity;
import com.sba.pm.entity.UserEntity;


@Repository("taskDao")
public class TaskDaoImpl implements ITaskDao {

	@Autowired 
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public Integer saveOrUpdateTask(TaskEntity taskEntity) {
		Integer result=0;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			session.saveOrUpdate(taskEntity);
			session.flush();
			result = taskEntity.getId();
			beginTransaction.commit();
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public TaskEntity getTask(Integer id) {
		TaskEntity task=null;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			task = (TaskEntity)session.get(TaskEntity.class, id);
			beginTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return task;
	}

	@Override
	public List<TaskEntity> getAllTasks() {
		List<TaskEntity> results=new ArrayList<>();
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<TaskEntity> createQuery = cb.createQuery(TaskEntity.class);
			Root<TaskEntity> root = createQuery.from(TaskEntity.class);
			createQuery.orderBy(cb.desc(root.get("id")));
			createQuery.select(root);
			 
			Query<TaskEntity> query = session.createQuery(createQuery);
			results = query.getResultList();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return results;
	}

	@Override
	public Integer deleteTask(Integer id) {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			TaskEntity task = (TaskEntity)session.get(TaskEntity.class, id);
			session.delete(task);
			beginTransaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}
}
