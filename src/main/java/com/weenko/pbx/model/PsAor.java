package com.weenko.pbx.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "ps_aors", catalog = "asterisk")
public class PsAor {
	private String id;
	private String contact;
	private Long defaultExpiration;
	private String mailboxes;
	private Long maxContacts;
	private Long minimumExpiration;
	private String remove_existing;
	private Long qualifyFrequency;
	private String authenticateQualify;
	private Long maximumExpiration;
	private String outboundProxy;
	private String supportPath;
	private Float qualifyTimeout;
	private String voicemailExtension;
	
	public PsAor() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PsAor(String id) {
		super();
		this.id = id;
		maxContacts = 1L;
	}
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Long getDefaultExpiration() {
		return defaultExpiration;
	}
	public void setDefaultExpiration(Long defaultExpiration) {
		this.defaultExpiration = defaultExpiration;
	}
	public String getMailboxes() {
		return mailboxes;
	}
	public void setMailboxes(String mailboxes) {
		this.mailboxes = mailboxes;
	}
	public Long getMaxContacts() {
		return maxContacts;
	}
	public void setMaxContacts(Long maxContacts) {
		this.maxContacts = maxContacts;
	}
	public Long getMinimumExpiration() {
		return minimumExpiration;
	}
	public void setMinimumExpiration(Long minimumExpiration) {
		this.minimumExpiration = minimumExpiration;
	}
	public String getRemove_existing() {
		return remove_existing;
	}
	public void setRemove_existing(String remove_existing) {
		this.remove_existing = remove_existing;
	}
	public Long getQualifyFrequency() {
		return qualifyFrequency;
	}
	public void setQualifyFrequency(Long qualifyFrequency) {
		this.qualifyFrequency = qualifyFrequency;
	}
	public String getAuthenticateQualify() {
		return authenticateQualify;
	}
	public void setAuthenticateQualify(String authenticateQualify) {
		this.authenticateQualify = authenticateQualify;
	}
	public Long getMaximumExpiration() {
		return maximumExpiration;
	}
	public void setMaximumExpiration(Long maximumExpiration) {
		this.maximumExpiration = maximumExpiration;
	}
	public String getOutboundProxy() {
		return outboundProxy;
	}
	public void setOutboundProxy(String outboundProxy) {
		this.outboundProxy = outboundProxy;
	}
	public String getSupportPath() {
		return supportPath;
	}
	public void setSupportPath(String supportPath) {
		this.supportPath = supportPath;
	}
	public Float getQualifyTimeout() {
		return qualifyTimeout;
	}
	public void setQualifyTimeout(Float qualifyTimeout) {
		this.qualifyTimeout = qualifyTimeout;
	}
	public String getVoicemailExtension() {
		return voicemailExtension;
	}
	public void setVoicemailExtension(String voicemailExtension) {
		this.voicemailExtension = voicemailExtension;
	}

	
}