package com.nickbi.mybatisplus.core;

import com.alibaba.fastjson.JSON;

/**
 * 统一API响应结果封装
 */
public class Result {
	private int code;
	private String message;
	private String debugMessage;
	private Object data;
	private boolean success;

	public Result setCode(ResultCode resultCode) {
		this.code = resultCode.code;
		return this;
	}

	public int getCode() {
		return code;
	}

	public Result setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Result setMessage(String message) {
		this.message = message;
		return this;
	}

	public Object getData() {
		return data;
	}

	public Result setData(Object data) {
		this.data = data;
		return this;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public Result setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
		return this;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	public boolean isSuccess() {
		if (this.code == ResultCode.SUCCESS.code) {
			return true;
		}
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
