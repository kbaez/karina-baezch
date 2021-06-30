package com.kbaez.karinabaezch.exception;

public class PriceNotFoundException extends RuntimeException {
	private String message;

	public PriceNotFoundException(String message) {
		super(message);
	}
}
