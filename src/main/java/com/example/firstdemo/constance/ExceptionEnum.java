package com.example.firstdemo.constance;

public enum ExceptionEnum {
	UNKOWN_ERROR(-1,"未知错误"),
	SUCCESS(0,"成功"),
	PRIMARY_SCHOOL(100,"你可能还在上小学"),
	MIDDLE_SCHOOL(101,"你可能还在上初中")
	;
	
	private Integer code;
	
	private String msg;

	private ExceptionEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
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
