package com.sba.pm.factory;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;

public class HibernateConfigFactory {
	EntityManagerFactory entityManagerFactory;

	public SessionFactory getSessionFactory() {
		if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("Hibernate factory not Available");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}
}
