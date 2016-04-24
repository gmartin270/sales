package org.guille.sales.persistence.hibernate;

import org.guille.sales.persistence.facade.exception.PersistenceException;
import org.guille.sales.persistence.facade.ICustomerPromotionPersist;
import org.guille.sales.persistence.hibernate.CustomerPromotionPersist;
import org.guille.sales.persistence.hibernate.HibernateUtil;

public class PersistenceFactory{
	public ICustomerPromotionPersist getCustomerPromotionPersist()
			throws PersistenceException {

		return new CustomerPromotionPersist(HibernateUtil.getSessionFactory()
				.openSession());
	}
}
