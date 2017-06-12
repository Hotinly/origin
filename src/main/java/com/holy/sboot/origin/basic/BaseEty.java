package com.holy.sboot.origin.basic;

import java.io.Serializable;
import java.util.Date;

import com.github.pagehelper.Page;

/**
 * 基础的公共信息类
 * 
 * @author Holy
 * @date 2017年6月7日 下午3:05:35
 * @ref
 */
public class BaseEty<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	// 创建者
	private String createBy;
	// 创建日期
	private Date createDate;
	// 修改者
	private String updateBy;
	// 修改日期
	private Date updateDate;
	// 状态(0：无效； 1：有效; 2：处理中)
	private String status;
	public static final char STATUS_DELETE = '0';
	public static final char STATUS_NORMAL = '1';
	public static final char STATUS_AUDIT = '2';
	// 备注
	private String remark;

	// 实体id
	protected Long id;
	// 当前用户
	protected String currentUser;
	// 分页
	protected Page<T> page;
	
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	public void preInsert(){
		// TODO
	}

	public void preUpdate(){
		// TODO
	}
}
