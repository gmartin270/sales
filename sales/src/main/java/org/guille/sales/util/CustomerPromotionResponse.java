package org.guille.sales.util;

public class CustomerPromotionResponse {
	public CustomerPromotionResponse() {
		super();
	}

	public int getApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public CustomerPromotionResponse(int approved, String comments) {
		super();
		this.approved = approved;
		this.comments = comments;
	}

	private int approved;
	private String comments;
}
