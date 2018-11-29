package com.exception;

/**
 * 初始化异常类
 * 
 * @author Rio
 * @Date 2018年2月6日 上午9:43:33
 */
public class InitializationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InitializationException(String stage, String message) {
		super("Initializtion Error At " + stage + " Stage" + ",Caused By:" + message);
	}

}
