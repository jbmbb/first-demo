package com.example.firstdemo.conf;

import com.example.firstdemo.constance.ExceptionEnum;

/**
 * 自定义异常
 * 
 * @author xxlai
 *
 */
public class MyException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2892469958236411695L;
	/** 错误编码 */
	private Integer code;

	public MyException(ExceptionEnum ex) {
		super(ex.getMsg());
		this.code = ex.getCode();
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	
}
