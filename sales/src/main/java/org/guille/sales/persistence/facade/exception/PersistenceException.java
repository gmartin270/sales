/*
 * Creado el 10-may-2006
 */
package org.guille.sales.persistence.facade.exception;


public class PersistenceException extends Exception {

	/**
	 * Comentario para <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -8327474832474143628L;

	/**
	 * 
	 */
	public PersistenceException() {
		super();
	}

	/**
	 * @param message
	 */
	public PersistenceException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public PersistenceException(Throwable cause) {
		super(cause);
	}

}
