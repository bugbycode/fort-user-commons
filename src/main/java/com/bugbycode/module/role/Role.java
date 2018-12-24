package com.bugbycode.module.role;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.util.StringUtil;

public class Role implements Serializable{

	public static final String LOGIN = "LOGIN"; 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4073044370792272927L;

	private int id;
	
	private String name;
	
	private String description;
	
	private String grantedAuthority;

	private Date createTime;
	
	private Date updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGrantedAuthority() {
		return grantedAuthority;
	}

	public void setGrantedAuthority(String grantedAuthority) {
		this.grantedAuthority = grantedAuthority;
	}
	
	public Set<String> grantList(){
		Set<String> set = new HashSet<String>();
		if(StringUtil.isNotBlank(this.grantedAuthority)) {
			set = StringUtils.commaDelimitedListToSet(this.grantedAuthority);
		}
		return set;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
