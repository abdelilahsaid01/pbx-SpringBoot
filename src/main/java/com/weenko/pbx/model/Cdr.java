package com.weenko.pbx.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Cdr {
  
	private String accountcode;
	private String src;
	private String dst;
	private String dcontext;
	private String clid;
	private String channel;
	private String dstchannel;
	private String lastapp;
	private String lastdata;
	private Date start;
	private Date answer;
	private Date end;
	private Long duration;
	private Long billsec;
	private String disposition;
	private String amaflags;
	private String userfield;
	private String uniqueid;
	private String linkedid;
	private String peeraccount;
	private Long sequence;
	
	public Cdr() {
		// TODO Auto-generated constructor stub
	}
	
	public String getAccountcode() {
		return accountcode;
	}
	public void setAccountcode(String accountcode) {
		this.accountcode = accountcode;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDst() {
		return dst;
	}
	public void setDst(String dst) {
		this.dst = dst;
	}
	public String getDcontext() {
		return dcontext;
	}
	public void setDcontext(String dcontext) {
		this.dcontext = dcontext;
	}
	public String getClid() {
		return clid;
	}
	public void setClid(String clid) {
		this.clid = clid;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getDstchannel() {
		return dstchannel;
	}
	public void setDstchannel(String dstchannel) {
		this.dstchannel = dstchannel;
	}
	public String getLastapp() {
		return lastapp;
	}
	public void setLastapp(String lastapp) {
		this.lastapp = lastapp;
	}
	public String getLastdata() {
		return lastdata;
	}
	public void setLastdata(String lastdata) {
		this.lastdata = lastdata;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getAnswer() {
		return answer;
	}
	public void setAnswer(Date answer) {
		this.answer = answer;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}

	public String getDisposition() {
		return disposition;
	}
	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}
	public String getAmaflags() {
		return amaflags;
	}
	public void setAmaflags(String amaflags) {
		this.amaflags = amaflags;
	}
	public String getUserfield() {
		return userfield;
	}
	public void setUserfield(String userfield) {
		this.userfield = userfield;
	}
	public String getUniqueid() {
		return uniqueid;
	}
	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}
	public String getLinkedid() {
		return linkedid;
	}
	public void setLinkedid(String linkedid) {
		this.linkedid = linkedid;
	}
	public String getPeeraccount() {
		return peeraccount;
	}
	public void setPeeraccount(String peeraccount) {
		this.peeraccount = peeraccount;
	}

	@Id
	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Long getBillsec() {
		return billsec;
	}

	public void setBillsec(Long billsec) {
		this.billsec = billsec;
	}
}