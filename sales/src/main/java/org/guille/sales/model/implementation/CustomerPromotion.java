package org.guille.sales.model.implementation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.guille.sales.model.ICustomerPromotion;

@Entity
@Table(name = "clientesPromociones")
public class CustomerPromotion implements ICustomerPromotion {

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getDeviceId() {
		return deviceId;
	}

	@Override
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public int getTicketId() {
		return ticketId;
	}

	@Override
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String getTel() {
		return tel;
	}

	@Override
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public boolean isSatisfaction() {
		return satisfaction;
	}

	@Override
	public void setSatisfaction(boolean satisfaction) {
		this.satisfaction = satisfaction;
	}

	@Override
	public boolean isProductFound() {
		return productFound;
	}

	@Override
	public void setProductFound(boolean productFound) {
		this.productFound = productFound;
	}

	@Override
	public int getAttentionRate() {
		return attentionRate;
	}

	@Override
	public void setAttentionRate(int attentionRate) {
		this.attentionRate = attentionRate;
	}

	@Override
	public boolean isGift() {
		return gift;
	}

	@Override
	public void setGift(boolean gift) {
		this.gift = gift;
	}

	@Override
	public String getComments() {
		return comments;
	}

	@Override
	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object obj) {
		return getEmail().equals(((ICustomerPromotion) obj).getEmail())
				|| getId() == ((ICustomerPromotion) obj).getId();
	}

	@Override
	public String toString() {
		return String
				.format("voucher=%s,id=%s,deviceId=%s,ticketId=%s,email=%s,firstName=%s,lastName=%s,tel=%s,satisfaction=%s,productFound=%s,attentionRate=%s,gift=%s,comments=%s",
						getVoucherCode(), getId(), getDeviceId(),
						getTicketId(), getEmail(), getFirstName(),
						getLastName(), getTel(), isSatisfaction(),
						isProductFound(), getAttentionRate(), isGift(),
						getComments());
	}

	@Id
	@GeneratedValue
	private int id;
	private String deviceId;
	private int ticketId;
	@Column(unique = true)
	private String email;
	private String firstName;
	private String lastName;
	private String tel;
	private boolean satisfaction;
	private boolean productFound;
	private int attentionRate;
	private boolean gift;
	@Column(columnDefinition = "TEXT")
	private String comments;
	private Date date;
	private int voucher;

	public int getVoucher() {
		return voucher;
	}

	public void setVoucher(int voucher) {
		this.voucher = voucher;
	}

	private String voucherCode;

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	@Column(columnDefinition = "TEXT")
	private String userAgent;
	private String clientIP;

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	
}
