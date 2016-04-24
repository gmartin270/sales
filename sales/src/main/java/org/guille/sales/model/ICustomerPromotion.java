package org.guille.sales.model;

import java.util.Date;

public interface ICustomerPromotion {

	public abstract int getId();

	public abstract void setId(int id);

	public abstract String getDeviceId();

	public abstract void setDeviceId(String deviceId);

	public abstract int getTicketId();

	public abstract void setTicketId(int ticketId);

	public abstract String getEmail();

	public abstract void setEmail(String email);

	public abstract String getFirstName();

	public abstract void setFirstName(String firstName);

	public abstract String getLastName();

	public abstract void setLastName(String lastName);

	public abstract String getTel();

	public abstract void setTel(String tel);

	public abstract boolean isSatisfaction();

	public abstract void setSatisfaction(boolean satisfaction);

	public abstract boolean isProductFound();

	public abstract void setProductFound(boolean productFound);

	public abstract int getAttentionRate();

	public abstract void setAttentionRate(int attentionRate);

	public abstract boolean isGift();

	public abstract void setGift(boolean gift);

	public abstract String getComments();

	public abstract void setComments(String comments);

	public Date getDate();

	public void setDate(Date date);

	public abstract void setVoucher(int voucher);

	public abstract int getVoucher();

	public String getVoucherCode();

	public void setVoucherCode(String voucherCode);

	public String getUserAgent();

	public void setUserAgent(String userAgent);

	public String getClientIP();

	public void setClientIP(String clientIP);

}