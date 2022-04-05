package com.weenko.pbx.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "ps_auths", catalog = "asterisk")
public class PsAuth {
	private String id;
	private String authType;
	private Long nonceLifetime;
	private String md5Cred;
	private String password;
	private String realm;
	private String username;
	
	public PsAuth() {
		// TODO Auto-generated constructor stub
	}
	
	public PsAuth(String id, String password, String oldPassword) {
		super();
		this.id = id;
		this.password = password != null && password.length() > 0 ? password:oldPassword;
		this.username = id;
	}
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthType() {
		return authType;
	}
	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public Long getNonceLifetime() {
		return nonceLifetime;
	}
	public void setNonceLifetime(Long nonceLifetime) {
		this.nonceLifetime = nonceLifetime;
	}
	
	@Column(name = "md5_cred")
	public String getMd5Cred() {
		return md5Cred;
	}
	public void setMd5Cred(String md5Cred) {
		this.md5Cred = md5Cred;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealm() {
		return realm;
	}
	public void setRealm(String realm) {
		this.realm = realm;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}