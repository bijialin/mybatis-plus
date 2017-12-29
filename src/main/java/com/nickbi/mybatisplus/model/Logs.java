package com.nickbi.mybatisplus.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 请求操作日志表
 * </p>
 *
 * @author nickBi
 * @since 2017-12-29
 */
@TableName("t_logs")
public class Logs extends Model<Logs> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 日志类型
     */
	private String type;
    /**
     * 日志标题
     */
	private String title;
    /**
     * 创建者
     */
	@TableField("create_user")
	private String createUser;
    /**
     * 创建时间
     */
	@TableField("create_date")
	private Date createDate;
    /**
     * 操作ip地址
     */
	@TableField("remote_addr")
	private String remoteAddr;
    /**
     * 用户代理
     */
	@TableField("user_agent")
	private String userAgent;
    /**
     * 请求URI
     */
	@TableField("request_uri")
	private String requestUri;
    /**
     * 请求方法
     */
	private String method;
    /**
     * 请求参数
     */
	private String params;
    /**
     * 异常信息
     */
	private String exception;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Logs{" +
			"id=" + id +
			", type=" + type +
			", title=" + title +
			", createUser=" + createUser +
			", createDate=" + createDate +
			", remoteAddr=" + remoteAddr +
			", userAgent=" + userAgent +
			", requestUri=" + requestUri +
			", method=" + method +
			", params=" + params +
			", exception=" + exception +
			"}";
	}
}
