package org.guille.sales.persistence.facade;

import org.guille.sales.model.ICustomerPromotion;

public interface ICustomerPromotionPersist {

	public ICustomerPromotion load(String email) throws Exception;
	public ICustomerPromotion load(int id) throws Exception;
	public ICustomerPromotion add(ICustomerPromotion customerPromotion) throws Exception;
	public void remove(int id) throws Exception;
	public void remove(String email) throws Exception;
}
