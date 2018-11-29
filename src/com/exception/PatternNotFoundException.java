package com.exception;

public class PatternNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatternNotFoundException(String name) {
		super(name + " Pattern Not Found");
	}

}