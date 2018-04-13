package com.example.firstdemo.conf;

/**
 * 自定义异常
 * @author xxlai
 *
 */
public class MyException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2892469958236411695L;
	/** 错误编码 */
	private String code;
	/** 错误信息 */
	private String msg;
	
	public MyException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public MyException(String msg) {
		super();
		this.msg = msg;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
