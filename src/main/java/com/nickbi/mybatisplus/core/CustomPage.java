package com.nickbi.mybatisplus.core;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * 由此对象将page对象转换成json对象，传到前台处理
 * 
 * @author ZuoLG
 *
 * @param <T>
 */
public class CustomPage<T> {

	// layui code
	private int code;
	
	private boolean success;

	// layui msg
	private int msg;

	// 当前页数
	private int page = 1;

	// 每页显示数量
	private int pageSize = 10;

	// 总条数
	private int count = 0;

	// 数据列表
	private List<T> data;

	// 总页数
	private int pages = 1;

	// 排序字段
	private String orderByField;

	// 是否升序
	private boolean isAsc;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCode() {
		if (this.data.size() > 0) {
			return ResultCode.SUCCESS.code;
		}
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getMsg() {
		if (this.data.size() > 0) {
			return ResultCode.SUCCESS.code;
		}
		return msg;
	}
	 
	public boolean isSuccess() {
		if (this.data.size() > 0) {
			return true;
		}
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setMsg(int msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getOrderByField() {
		return orderByField;
	}

	public void setOrderByField(String orderByField) {
		this.orderByField = orderByField;
	}

	public boolean isAsc() {
		return isAsc;
	}

	public void setAsc(boolean isAsc) {
		this.isAsc = isAsc;
	}

	public CustomPage() {
	}

	// 响应转换
	public CustomPage(Page<T> page) {
		this.page = page.getCurrent();
		this.pageSize = page.getSize();
		this.count = page.getTotal();
		this.data = page.getRecords();
		this.pages = page.getPages();
		this.orderByField = page.getOrderByField();
		this.isAsc = page.isAsc();
	}

	// 获取mybatisPlus封装的Page对象
	public Page<T> myPagePlus() {
		Page<T> pagePlus = new Page<T>();
		pagePlus.setCurrent(this.page);
		pagePlus.setSize(this.pageSize);
		pagePlus.setAsc(this.isAsc);
		pagePlus.setOrderByField(this.orderByField);
		return pagePlus;
	}
}