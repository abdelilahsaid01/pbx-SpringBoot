package com.weenko.pbx.model;

import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Subscriber {
  
    private Long id;
    
    private String firstname;
	private String lastname;
	private String description;
	private String type;
	private String username;
	private String password;
	private Double balance;
	
	private Integer busy;
    
    private Date createTimestamp;
    private Date updateTimestamp;
    
    private List<BwEntry> bwEntries;
    private Set<Dnd> dnds;
  
    public Subscriber() {
		// TODO Auto-generated constructor stub
	}
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
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
	
	@OneToMany(mappedBy = "subscriber", fetch=FetchType.LAZY)
	public List<BwEntry> getBwEntries() {
		return bwEntries;
	}
	public void setBwEntries(List<BwEntry> bwEntries) {
		this.bwEntries = bwEntries;
	}
	@Override
	public String toString() {
		return firstname + " " + lastname;
	}

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "subscribers_dnds",
        joinColumns = @JoinColumn(
          name = "subscriber_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "dnd_id", referencedColumnName = "id"))
	public Set<Dnd> getDnds() {
		return dnds;
	}

	public void setDnds(Set<Dnd> dnds) {
		this.dnds = dnds;
	}

	public Integer getBusy() {
		return busy;
	}

	public void setBusy(Integer busy) {
		this.busy = busy;
	}
	
	
}
