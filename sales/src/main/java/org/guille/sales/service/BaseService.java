package org.guille.sales.service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

public class BaseService {
	private ServletContext servletContext;

	public ServletContext getServletContext() {
		return servletContext;
	}

	@Context
	private HttpServletRequest servletRequest;

	HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	@Context
	void setServletContext(ServletContext context) {
		this.servletContext = context;

	}
}
