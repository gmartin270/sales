package org.guille.sales.persistence.hibernate;

import java.text.DecimalFormat;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.guille.sales.model.ICustomerPromotion;
import org.guille.sales.model.implementation.CustomerPromotion;
import org.guille.sales.persistence.facade.ICustomerPromotionPersist;

public class CustomerPromotionPersist implements ICustomerPromotionPersist {
	private static Logger LOG = LoggerFactory
			.getLogger(CustomerPromotion.class);

	private Session session = null;

	public CustomerPromotionPersist(Session session) {
		this.session = session;
	}

	@Override
	public ICustomerPromotion load(String email) throws Exception {
		ICustomerPromotion r = null;
		try {
			Query query = session
					.createQuery("FROM CustomerPromotion WHERE email= :email");
			query.setString("email", email);
			r = (ICustomerPromotion) query.uniqueResult();
			LOG.debug("Cargado: {}");
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new Exception(e);
		}
		return r;
	}

	@Override
	public ICustomerPromotion load(int id) throws Exception {
		ICustomerPromotion r = null;
		try {
			Query query = session
					.createQuery("FROM CustomerPromotion WHERE id= :id");
			query.setInteger("id", id);
			r = (ICustomerPromotion) query.uniqueResult();
			LOG.debug("Cargado: {}");
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new Exception(e);
		}
		return r;
	}

	@Override
	public ICustomerPromotion add(ICustomerPromotion customerPromotion)
			throws Exception {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String queryStr = "SELECT MAX(voucher) FROM CustomerPromotion";
			Query query = session.createQuery(queryStr);
			Integer voucher = (Integer) query.uniqueResult();
			if (voucher == null)
				voucher = 1;
			else
				voucher = voucher + 1;
			customerPromotion.setVoucher(voucher);
			DecimalFormat sd = new DecimalFormat("0000");
			customerPromotion.setVoucherCode("PES062015" + sd.format(voucher));
			session.save(customerPromotion);
			tx.commit();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			if (tx != null)
				tx.rollback();
			throw new Exception(e);
		}
		LOG.debug("{} almacenado", customerPromotion);
		return customerPromotion;
	}

	@Override
	public void remove(int id) throws Exception {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE FROM CustomerPromotion WHERE id= :id";
			Query query = session.createQuery(hql);
			query.setInteger("id", id);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			if (tx != null)
				tx.rollback();
			throw new Exception(e);
		}

	}

	@Override
	public void remove(String email) throws Exception {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE FROM CustomerPromotion WHERE email= :email";
			Query query = session.createQuery(hql);
			query.setString("email", email);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			if (tx != null)
				tx.rollback();
			throw new Exception(e);
		}

	}

}
