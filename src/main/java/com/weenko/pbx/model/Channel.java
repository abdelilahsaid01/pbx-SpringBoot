package com.weenko.pbx.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
public class Channel {
  
    private Long id;
 
    private String name;
    private String username;
    private String password;
    private String address;
    private String type;
    private String description;
    private Date createTimestamp;
    private Date updateTimestamp;
    private Set<Dnd> dnds;
    
    public Channel() {
		// TODO Auto-generated constructor stub
	}
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	public Date getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	
	@UpdateTimestamp
	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}
	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return name;
	}
	
	public void copyFrom(Channel channel) {
	    name = channel.name;
	    username = channel.username;
	    if(channel.password != null && channel.password.length() > 0)
	    	password = channel.password;
	    address = channel.address;
	    type = channel.type;
	    description = channel.description;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "channels_dnds",
        joinColumns = @JoinColumn(
          name = "channel_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "dnd_id", referencedColumnName = "id"))
	public Set<Dnd> getDnds() {
		return dnds;
	}

	public void setDnds(Set<Dnd> dnds) {
		this.dnds = dnds;
	}
	
	
}