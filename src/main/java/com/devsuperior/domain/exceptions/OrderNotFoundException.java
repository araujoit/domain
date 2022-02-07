package com.devsuperior.domain.exceptions;

import org.springframework.web.client.RestClientException;

public class OrderNotFoundException extends RestClientException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(Long id) {
		super("Order com id " + id + " não encontrada na base");
	}

}
