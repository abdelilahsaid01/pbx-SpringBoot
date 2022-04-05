package com.weenko.pbx.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Dnd {
  
    private Long id;
 
    private String name;
    
    private Set<Subscriber> subscribers;
    private Set<Channel> channels;
    private String description;
    private String startTime;
    private String endTime;
    private boolean day1;
    private boolean day2;
    private boolean day3;
    private boolean day4;
    private boolean day5;
    private boolean day6;
    private boolean day7;
    private Date createTimestamp;
    private Date updateTimestamp;
    
    public Dnd() {
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public boolean isDay1() {
		return day1;
	}
	public void setDay1(boolean day1) {
		this.day1 = day1;
	}
	public boolean isDay2() {
		return day2;
	}
	public void setDay2(boolean day2) {
		this.day2 = day2;
	}
	public boolean isDay3() {
		return day3;
	}
	public void setDay3(boolean day3) {
		this.day3 = day3;
	}
	public boolean isDay4() {
		return day4;
	}
	public void setDay4(boolean day4) {
		this.day4 = day4;
	}
	public boolean isDay5() {
		return day5;
	}
	public void setDay5(boolean day5) {
		this.day5 = day5;
	}
	public boolean isDay6() {
		return day6;
	}
	public void setDay6(boolean day6) {
		this.day6 = day6;
	}
	public boolean isDay7() {
		return day7;
	}
	public void setDay7(boolean day7) {
		this.day7 = day7;
	}

	@ManyToMany(mappedBy = "dnds")
	public Set<Subscriber> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(Set<Subscriber> subscribers) {
		this.subscribers = subscribers;
	}

	@ManyToMany(mappedBy = "dnds")
	public Set<Channel> getChannels() {
		return channels;
	}

	public void setChannels(Set<Channel> channels) {
		this.channels = channels;
	}
	
	
}