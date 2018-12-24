package com.bugbycode.module.user;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import com.bugbycode.module.role.Role;

public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 945180841136487083L;
	
	private int id;
	
	private String username;
	
	private String password;
	
	private String name;
	
	private String email;
	
	private String mobile;
	
	private int status;
	
	private int type;
	
	private List<Role> roleList;
	
	private Date createTime;
	
	private Date updateTime;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> grant = new HashSet<GrantedAuthority>();
		if(!CollectionUtils.isEmpty(this.roleList)) {
			int len = this.roleList.size();
			for(int index = 0;index < len;index++) {
				Set<String> grantSet = this.roleList.get(index).grantList();
				if(!CollectionUtils.isEmpty(grantSet)) {
					for(String grantStr : grantSet) {
						grant.add(new SimpleGrantedAuthority("ROLE_" + grantStr));
					}
				}
			}
		}
		return grant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
