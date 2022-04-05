package com.weenko.pbx.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;



@Entity
@Table(name = "ps_endpoints", catalog = "asterisk")
public class PsEndpoint {

	@Id
	private String id;
	
	@Column(name="100rel")
	private String _00rel;

	@Column(name="accept_multiple_sdp_answers")
	private String acceptMultipleSdpAnswers;

	private String accountcode;

	private String acl;

	@Column(name="aggregate_mwi")
	private String aggregateMwi;

	private String allow;

	@Column(name="allow_overlap")
	private String allowOverlap;

	@Column(name="allow_subscribe")
	private String allowSubscribe;

	@Column(name="allow_transfer")
	private String allowTransfer;

	private String aors;

	@Column(name="asymmetric_rtp_codec")
	private String asymmetricRtpCodec;

	private String auth;

	@Column(name="bind_rtp_to_media_address")
	private String bindRtpToMediaAddress;

	private String bundle;

	@Column(name="call_group")
	private String callGroup;

	private String callerid;

	@Column(name="callerid_privacy")
	private String calleridPrivacy;

	@Column(name="callerid_tag")
	private String calleridTag;

	@Column(name="connected_line_method")
	private String connectedLineMethod;

	@Column(name="contact_acl")
	private String contactAcl;

	@Column(name="contact_deny")
	private String contactDeny;

	@Column(name="contact_permit")
	private String contactPermit;

	@Column(name="contact_user")
	private String contactUser;

	private String context;

	@Column(name="cos_audio")
	private Integer cosAudio;

	@Column(name="cos_video")
	private Integer cosVideo;

	private String deny;

	@Column(name="device_state_busy_at")
	private Integer deviceStateBusyAt;

	@Column(name="direct_media")
	private String directMedia;

	@Column(name="direct_media_glare_mitigation")
	private String directMediaGlareMitigation;

	@Column(name="direct_media_method")
	private String directMediaMethod;

	@Column(name="disable_direct_media_on_nat")
	private String disableDirectMediaOnNat;

	private String disallow;

	@Column(name="dtls_auto_generate_cert")
	private String dtlsAutoGenerateCert;

	@Column(name="dtls_ca_file")
	private String dtlsCaFile;

	@Column(name="dtls_ca_path")
	private String dtlsCaPath;

	@Column(name="dtls_cert_file")
	private String dtlsCertFile;

	@Column(name="dtls_cipher")
	private String dtlsCipher;

	@Column(name="dtls_fingerprint")
	private String dtlsFingerprint;

	@Column(name="dtls_private_key")
	private String dtlsPrivateKey;

	@Column(name="dtls_rekey")
	private String dtlsRekey;

	@Column(name="dtls_setup")
	private String dtlsSetup;

	@Column(name="dtls_verify")
	private String dtlsVerify;

	@Column(name="dtmf_mode")
	private String dtmfMode;

	@Column(name="external_media_address")
	private String externalMediaAddress;

	@Column(name="fax_detect")
	private String faxDetect;

	@Column(name="fax_detect_timeout")
	private Integer faxDetectTimeout;

	@Column(name="follow_early_media_fork")
	private String followEarlyMediaFork;

	@Column(name="force_avp")
	private String forceAvp;

	@Column(name="force_rport")
	private String forceRport;

	@Column(name="from_domain")
	private String fromDomain;

	@Column(name="from_user")
	private String fromUser;

	@Column(name="g726_non_standard")
	private String g726NonStandard;

	@Column(name="ice_support")
	private String iceSupport;

	@Column(name="identify_by")
	private String identifyBy;

	@Column(name="ignore_183_without_sdp")
	private String ignore183WithoutSdp;

	@Column(name="inband_progress")
	private String inbandProgress;

	@Column(name="incoming_mwi_mailbox")
	private String incomingMwiMailbox;

	private String language;

	private String mailboxes;

	@Column(name="max_audio_streams")
	private Integer maxAudioStreams;

	@Column(name="max_video_streams")
	private Integer maxVideoStreams;

	@Column(name="media_address")
	private String mediaAddress;

	@Column(name="media_encryption")
	private String mediaEncryption;

	@Column(name="media_encryption_optimistic")
	private String mediaEncryptionOptimistic;

	@Column(name="media_use_received_transport")
	private String mediaUseReceivedTransport;

	@Column(name="message_context")
	private String messageContext;

	@Column(name="moh_passthrough")
	private String mohPassthrough;

	@Column(name="moh_suggest")
	private String mohSuggest;

	@Column(name="mwi_from_user")
	private String mwiFromUser;

	@Column(name="mwi_subscribe_replaces_unsolicited")
	private String mwiSubscribeReplacesUnsolicited;

	@Column(name="named_call_group")
	private String namedCallGroup;

	@Column(name="named_pickup_group")
	private String namedPickupGroup;

	@Column(name="notify_early_inuse_ringing")
	private String notifyEarlyInuseRinging;

	@Column(name="one_touch_recording")
	private String oneTouchRecording;

	@Column(name="outbound_auth")
	private String outboundAuth;

	@Column(name="outbound_proxy")
	private String outboundProxy;

	private String permit;

	@Column(name="pickup_group")
	private String pickupGroup;

	@Column(name="preferred_codec_only")
	private String preferredCodecOnly;

	@Column(name="record_off_feature")
	private String recordOffFeature;

	@Column(name="record_on_feature")
	private String recordOnFeature;

	@Column(name="redirect_method")
	private String redirectMethod;

	@Column(name="refer_blind_progress")
	private String referBlindProgress;

	@Column(name="rewrite_contact")
	private String rewriteContact;

	@Column(name="rpid_immediate")
	private String rpidImmediate;

	@Column(name="rtcp_mux")
	private String rtcpMux;

	@Column(name="rtp_engine")
	private String rtpEngine;

	@Column(name="rtp_ipv6")
	private String rtpIpv6;

	@Column(name="rtp_keepalive")
	private Integer rtpKeepalive;

	@Column(name="rtp_symmetric")
	private String rtpSymmetric;

	@Column(name="rtp_timeout")
	private Integer rtpTimeout;

	@Column(name="rtp_timeout_hold")
	private Integer rtpTimeoutHold;

	@Column(name="sdp_owner")
	private String sdpOwner;

	@Column(name="sdp_session")
	private String sdpSession;

	@Column(name="send_connected_line")
	private String sendConnectedLine;

	@Column(name="send_diversion")
	private String sendDiversion;

	@Column(name="send_history_info")
	private String sendHistoryInfo;

	@Column(name="send_pai")
	private String sendPai;

	@Column(name="send_rpid")
	private String sendRpid;

	@Lob
	@Column(name="set_var")
	private String setVar;

	@Column(name="srtp_tag_32")
	private String srtpTag32;

	@Column(name="stir_shaken")
	private String stirShaken;

	@Column(name="sub_min_expiry")
	private Integer subMinExpiry;

	@Column(name="subscribe_context")
	private String subscribeContext;

	@Column(name="suppress_q850_reason_headers")
	private String suppressQ850ReasonHeaders;

	@Column(name="t38_udptl")
	private String t38Udptl;

	@Column(name="t38_udptl_ec")
	private String t38UdptlEc;

	@Column(name="t38_udptl_ipv6")
	private String t38UdptlIpv6;

	@Column(name="t38_udptl_maxdatagram")
	private Integer t38UdptlMaxdatagram;

	@Column(name="t38_udptl_nat")
	private String t38UdptlNat;

	private String timers;

	@Column(name="timers_min_se")
	private Integer timersMinSe;

	@Column(name="timers_sess_expires")
	private Integer timersSessExpires;

	@Column(name="tone_zone")
	private String toneZone;

	@Column(name="tos_audio")
	private String tosAudio;

	@Column(name="tos_video")
	private String tosVideo;

	private String transport;

	@Column(name="trust_connected_line")
	private String trustConnectedLine;

	@Column(name="trust_id_inbound")
	private String trustIdInbound;

	@Column(name="trust_id_outbound")
	private String trustIdOutbound;

	@Column(name="use_avpf")
	private String useAvpf;

	@Column(name="use_ptime")
	private String usePtime;

	@Column(name="user_eq_phone")
	private String userEqPhone;

	@Column(name="voicemail_extension")
	private String voicemailExtension;

	private String webrtc;

	static final String TRANSPORT = "transport-udp";
	static final String CONTEXT = "sets";
	static final String DISALLOW = "all";
	static final String ALLOW = "ulaw";
	static final String DIRECT_MEDIA = "no";
	
	public PsEndpoint() {
		// TODO Auto-generated constructor stub
	}
	
	public PsEndpoint(String id) {
		super();
		this.auth = this.aors = this.id = id;
		transport = TRANSPORT;
		context = CONTEXT;
		disallow = DISALLOW;
		allow = ALLOW;
		directMedia = DIRECT_MEDIA;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String get_00rel() {
		return _00rel;
	}

	public void set_00rel(String _00rel) {
		this._00rel = _00rel;
	}

	public String getAcceptMultipleSdpAnswers() {
		return acceptMultipleSdpAnswers;
	}

	public void setAcceptMultipleSdpAnswers(String acceptMultipleSdpAnswers) {
		this.acceptMultipleSdpAnswers = acceptMultipleSdpAnswers;
	}

	public String getAccountcode() {
		return accountcode;
	}

	public void setAccountcode(String accountcode) {
		this.accountcode = accountcode;
	}

	public String getAcl() {
		return acl;
	}

	public void setAcl(String acl) {
		this.acl = acl;
	}

	public String getAggregateMwi() {
		return aggregateMwi;
	}

	public void setAggregateMwi(String aggregateMwi) {
		this.aggregateMwi = aggregateMwi;
	}

	public String getAllow() {
		return allow;
	}

	public void setAllow(String allow) {
		this.allow = allow;
	}

	public String getAllowOverlap() {
		return allowOverlap;
	}

	public void setAllowOverlap(String allowOverlap) {
		this.allowOverlap = allowOverlap;
	}

	public String getAllowSubscribe() {
		return allowSubscribe;
	}

	public void setAllowSubscribe(String allowSubscribe) {
		this.allowSubscribe = allowSubscribe;
	}

	public String getAllowTransfer() {
		return allowTransfer;
	}

	public void setAllowTransfer(String allowTransfer) {
		this.allowTransfer = allowTransfer;
	}

	public String getAors() {
		return aors;
	}

	public void setAors(String aors) {
		this.aors = aors;
	}

	public String getAsymmetricRtpCodec() {
		return asymmetricRtpCodec;
	}

	public void setAsymmetricRtpCodec(String asymmetricRtpCodec) {
		this.asymmetricRtpCodec = asymmetricRtpCodec;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getBindRtpToMediaAddress() {
		return bindRtpToMediaAddress;
	}

	public void setBindRtpToMediaAddress(String bindRtpToMediaAddress) {
		this.bindRtpToMediaAddress = bindRtpToMediaAddress;
	}

	public String getBundle() {
		return bundle;
	}

	public void setBundle(String bundle) {
		this.bundle = bundle;
	}

	public String getCallGroup() {
		return callGroup;
	}

	public void setCallGroup(String callGroup) {
		this.callGroup = callGroup;
	}

	public String getCallerid() {
		return callerid;
	}

	public void setCallerid(String callerid) {
		this.callerid = callerid;
	}

	public String getCalleridPrivacy() {
		return calleridPrivacy;
	}

	public void setCalleridPrivacy(String calleridPrivacy) {
		this.calleridPrivacy = calleridPrivacy;
	}

	public String getCalleridTag() {
		return calleridTag;
	}

	public void setCalleridTag(String calleridTag) {
		this.calleridTag = calleridTag;
	}

	public String getConnectedLineMethod() {
		return connectedLineMethod;
	}

	public void setConnectedLineMethod(String connectedLineMethod) {
		this.connectedLineMethod = connectedLineMethod;
	}

	public String getContactAcl() {
		return contactAcl;
	}

	public void setContactAcl(String contactAcl) {
		this.contactAcl = contactAcl;
	}

	public String getContactDeny() {
		return contactDeny;
	}

	public void setContactDeny(String contactDeny) {
		this.contactDeny = contactDeny;
	}

	public String getContactPermit() {
		return contactPermit;
	}

	public void setContactPermit(String contactPermit) {
		this.contactPermit = contactPermit;
	}

	public String getContactUser() {
		return contactUser;
	}

	public void setContactUser(String contactUser) {
		this.contactUser = contactUser;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getCosAudio() {
		return cosAudio;
	}

	public void setCosAudio(Integer cosAudio) {
		this.cosAudio = cosAudio;
	}

	public Integer getCosVideo() {
		return cosVideo;
	}

	public void setCosVideo(Integer cosVideo) {
		this.cosVideo = cosVideo;
	}

	public String getDeny() {
		return deny;
	}

	public void setDeny(String deny) {
		this.deny = deny;
	}

	public Integer getDeviceStateBusyAt() {
		return deviceStateBusyAt;
	}

	public void setDeviceStateBusyAt(Integer deviceStateBusyAt) {
		this.deviceStateBusyAt = deviceStateBusyAt;
	}

	public String getDirectMedia() {
		return directMedia;
	}

	public void setDirectMedia(String directMedia) {
		this.directMedia = directMedia;
	}

	public String getDirectMediaGlareMitigation() {
		return directMediaGlareMitigation;
	}

	public void setDirectMediaGlareMitigation(String directMediaGlareMitigation) {
		this.directMediaGlareMitigation = directMediaGlareMitigation;
	}

	public String getDirectMediaMethod() {
		return directMediaMethod;
	}

	public void setDirectMediaMethod(String directMediaMethod) {
		this.directMediaMethod = directMediaMethod;
	}

	public String getDisableDirectMediaOnNat() {
		return disableDirectMediaOnNat;
	}

	public void setDisableDirectMediaOnNat(String disableDirectMediaOnNat) {
		this.disableDirectMediaOnNat = disableDirectMediaOnNat;
	}

	public String getDisallow() {
		return disallow;
	}

	public void setDisallow(String disallow) {
		this.disallow = disallow;
	}

	public String getDtlsAutoGenerateCert() {
		return dtlsAutoGenerateCert;
	}

	public void setDtlsAutoGenerateCert(String dtlsAutoGenerateCert) {
		this.dtlsAutoGenerateCert = dtlsAutoGenerateCert;
	}

	public String getDtlsCaFile() {
		return dtlsCaFile;
	}

	public void setDtlsCaFile(String dtlsCaFile) {
		this.dtlsCaFile = dtlsCaFile;
	}

	public String getDtlsCaPath() {
		return dtlsCaPath;
	}

	public void setDtlsCaPath(String dtlsCaPath) {
		this.dtlsCaPath = dtlsCaPath;
	}

	public String getDtlsCertFile() {
		return dtlsCertFile;
	}

	public void setDtlsCertFile(String dtlsCertFile) {
		this.dtlsCertFile = dtlsCertFile;
	}

	public String getDtlsCipher() {
		return dtlsCipher;
	}

	public void setDtlsCipher(String dtlsCipher) {
		this.dtlsCipher = dtlsCipher;
	}

	public String getDtlsFingerprint() {
		return dtlsFingerprint;
	}

	public void setDtlsFingerprint(String dtlsFingerprint) {
		this.dtlsFingerprint = dtlsFingerprint;
	}

	public String getDtlsPrivateKey() {
		return dtlsPrivateKey;
	}

	public void setDtlsPrivateKey(String dtlsPrivateKey) {
		this.dtlsPrivateKey = dtlsPrivateKey;
	}

	public String getDtlsRekey() {
		return dtlsRekey;
	}

	public void setDtlsRekey(String dtlsRekey) {
		this.dtlsRekey = dtlsRekey;
	}

	public String getDtlsSetup() {
		return dtlsSetup;
	}

	public void setDtlsSetup(String dtlsSetup) {
		this.dtlsSetup = dtlsSetup;
	}

	public String getDtlsVerify() {
		return dtlsVerify;
	}

	public void setDtlsVerify(String dtlsVerify) {
		this.dtlsVerify = dtlsVerify;
	}

	public String getDtmfMode() {
		return dtmfMode;
	}

	public void setDtmfMode(String dtmfMode) {
		this.dtmfMode = dtmfMode;
	}

	public String getExternalMediaAddress() {
		return externalMediaAddress;
	}

	public void setExternalMediaAddress(String externalMediaAddress) {
		this.externalMediaAddress = externalMediaAddress;
	}

	public String getFaxDetect() {
		return faxDetect;
	}

	public void setFaxDetect(String faxDetect) {
		this.faxDetect = faxDetect;
	}

	public Integer getFaxDetectTimeout() {
		return faxDetectTimeout;
	}

	public void setFaxDetectTimeout(Integer faxDetectTimeout) {
		this.faxDetectTimeout = faxDetectTimeout;
	}

	public String getFollowEarlyMediaFork() {
		return followEarlyMediaFork;
	}

	public void setFollowEarlyMediaFork(String followEarlyMediaFork) {
		this.followEarlyMediaFork = followEarlyMediaFork;
	}

	public String getForceAvp() {
		return forceAvp;
	}

	public void setForceAvp(String forceAvp) {
		this.forceAvp = forceAvp;
	}

	public String getForceRport() {
		return forceRport;
	}

	public void setForceRport(String forceRport) {
		this.forceRport = forceRport;
	}

	public String getFromDomain() {
		return fromDomain;
	}

	public void setFromDomain(String fromDomain) {
		this.fromDomain = fromDomain;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getG726NonStandard() {
		return g726NonStandard;
	}

	public void setG726NonStandard(String g726NonStandard) {
		this.g726NonStandard = g726NonStandard;
	}

	public String getIceSupport() {
		return iceSupport;
	}

	public void setIceSupport(String iceSupport) {
		this.iceSupport = iceSupport;
	}

	public String getIdentifyBy() {
		return identifyBy;
	}

	public void setIdentifyBy(String identifyBy) {
		this.identifyBy = identifyBy;
	}

	public String getIgnore183WithoutSdp() {
		return ignore183WithoutSdp;
	}

	public void setIgnore183WithoutSdp(String ignore183WithoutSdp) {
		this.ignore183WithoutSdp = ignore183WithoutSdp;
	}

	public String getInbandProgress() {
		return inbandProgress;
	}

	public void setInbandProgress(String inbandProgress) {
		this.inbandProgress = inbandProgress;
	}

	public String getIncomingMwiMailbox() {
		return incomingMwiMailbox;
	}

	public void setIncomingMwiMailbox(String incomingMwiMailbox) {
		this.incomingMwiMailbox = incomingMwiMailbox;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMailboxes() {
		return mailboxes;
	}

	public void setMailboxes(String mailboxes) {
		this.mailboxes = mailboxes;
	}

	public Integer getMaxAudioStreams() {
		return maxAudioStreams;
	}

	public void setMaxAudioStreams(Integer maxAudioStreams) {
		this.maxAudioStreams = maxAudioStreams;
	}

	public Integer getMaxVideoStreams() {
		return maxVideoStreams;
	}

	public void setMaxVideoStreams(Integer maxVideoStreams) {
		this.maxVideoStreams = maxVideoStreams;
	}

	public String getMediaAddress() {
		return mediaAddress;
	}

	public void setMediaAddress(String mediaAddress) {
		this.mediaAddress = mediaAddress;
	}

	public String getMediaEncryption() {
		return mediaEncryption;
	}

	public void setMediaEncryption(String mediaEncryption) {
		this.mediaEncryption = mediaEncryption;
	}

	public String getMediaEncryptionOptimistic() {
		return mediaEncryptionOptimistic;
	}

	public void setMediaEncryptionOptimistic(String mediaEncryptionOptimistic) {
		this.mediaEncryptionOptimistic = mediaEncryptionOptimistic;
	}

	public String getMediaUseReceivedTransport() {
		return mediaUseReceivedTransport;
	}

	public void setMediaUseReceivedTransport(String mediaUseReceivedTransport) {
		this.mediaUseReceivedTransport = mediaUseReceivedTransport;
	}

	public String getMessageContext() {
		return messageContext;
	}

	public void setMessageContext(String messageContext) {
		this.messageContext = messageContext;
	}

	public String getMohPassthrough() {
		return mohPassthrough;
	}

	public void setMohPassthrough(String mohPassthrough) {
		this.mohPassthrough = mohPassthrough;
	}

	public String getMohSuggest() {
		return mohSuggest;
	}

	public void setMohSuggest(String mohSuggest) {
		this.mohSuggest = mohSuggest;
	}

	public String getMwiFromUser() {
		return mwiFromUser;
	}

	public void setMwiFromUser(String mwiFromUser) {
		this.mwiFromUser = mwiFromUser;
	}

	public String getMwiSubscribeReplacesUnsolicited() {
		return mwiSubscribeReplacesUnsolicited;
	}

	public void setMwiSubscribeReplacesUnsolicited(String mwiSubscribeReplacesUnsolicited) {
		this.mwiSubscribeReplacesUnsolicited = mwiSubscribeReplacesUnsolicited;
	}

	public String getNamedCallGroup() {
		return namedCallGroup;
	}

	public void setNamedCallGroup(String namedCallGroup) {
		this.namedCallGroup = namedCallGroup;
	}

	public String getNamedPickupGroup() {
		return namedPickupGroup;
	}

	public void setNamedPickupGroup(String namedPickupGroup) {
		this.namedPickupGroup = namedPickupGroup;
	}

	public String getNotifyEarlyInuseRinging() {
		return notifyEarlyInuseRinging;
	}

	public void setNotifyEarlyInuseRinging(String notifyEarlyInuseRinging) {
		this.notifyEarlyInuseRinging = notifyEarlyInuseRinging;
	}

	public String getOneTouchRecording() {
		return oneTouchRecording;
	}

	public void setOneTouchRecording(String oneTouchRecording) {
		this.oneTouchRecording = oneTouchRecording;
	}

	public String getOutboundAuth() {
		return outboundAuth;
	}

	public void setOutboundAuth(String outboundAuth) {
		this.outboundAuth = outboundAuth;
	}

	public String getOutboundProxy() {
		return outboundProxy;
	}

	public void setOutboundProxy(String outboundProxy) {
		this.outboundProxy = outboundProxy;
	}

	public String getPermit() {
		return permit;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	public String getPickupGroup() {
		return pickupGroup;
	}

	public void setPickupGroup(String pickupGroup) {
		this.pickupGroup = pickupGroup;
	}

	public String getPreferredCodecOnly() {
		return preferredCodecOnly;
	}

	public void setPreferredCodecOnly(String preferredCodecOnly) {
		this.preferredCodecOnly = preferredCodecOnly;
	}

	public String getRecordOffFeature() {
		return recordOffFeature;
	}

	public void setRecordOffFeature(String recordOffFeature) {
		this.recordOffFeature = recordOffFeature;
	}

	public String getRecordOnFeature() {
		return recordOnFeature;
	}

	public void setRecordOnFeature(String recordOnFeature) {
		this.recordOnFeature = recordOnFeature;
	}

	public String getRedirectMethod() {
		return redirectMethod;
	}

	public void setRedirectMethod(String redirectMethod) {
		this.redirectMethod = redirectMethod;
	}

	public String getReferBlindProgress() {
		return referBlindProgress;
	}

	public void setReferBlindProgress(String referBlindProgress) {
		this.referBlindProgress = referBlindProgress;
	}

	public String getRewriteContact() {
		return rewriteContact;
	}

	public void setRewriteContact(String rewriteContact) {
		this.rewriteContact = rewriteContact;
	}

	public String getRpidImmediate() {
		return rpidImmediate;
	}

	public void setRpidImmediate(String rpidImmediate) {
		this.rpidImmediate = rpidImmediate;
	}

	public String getRtcpMux() {
		return rtcpMux;
	}

	public void setRtcpMux(String rtcpMux) {
		this.rtcpMux = rtcpMux;
	}

	public String getRtpEngine() {
		return rtpEngine;
	}

	public void setRtpEngine(String rtpEngine) {
		this.rtpEngine = rtpEngine;
	}

	public String getRtpIpv6() {
		return rtpIpv6;
	}

	public void setRtpIpv6(String rtpIpv6) {
		this.rtpIpv6 = rtpIpv6;
	}

	public Integer getRtpKeepalive() {
		return rtpKeepalive;
	}

	public void setRtpKeepalive(Integer rtpKeepalive) {
		this.rtpKeepalive = rtpKeepalive;
	}

	public String getRtpSymmetric() {
		return rtpSymmetric;
	}

	public void setRtpSymmetric(String rtpSymmetric) {
		this.rtpSymmetric = rtpSymmetric;
	}

	public Integer getRtpTimeout() {
		return rtpTimeout;
	}

	public void setRtpTimeout(Integer rtpTimeout) {
		this.rtpTimeout = rtpTimeout;
	}

	public Integer getRtpTimeoutHold() {
		return rtpTimeoutHold;
	}

	public void setRtpTimeoutHold(Integer rtpTimeoutHold) {
		this.rtpTimeoutHold = rtpTimeoutHold;
	}

	public String getSdpOwner() {
		return sdpOwner;
	}

	public void setSdpOwner(String sdpOwner) {
		this.sdpOwner = sdpOwner;
	}

	public String getSdpSession() {
		return sdpSession;
	}

	public void setSdpSession(String sdpSession) {
		this.sdpSession = sdpSession;
	}

	public String getSendConnectedLine() {
		return sendConnectedLine;
	}

	public void setSendConnectedLine(String sendConnectedLine) {
		this.sendConnectedLine = sendConnectedLine;
	}

	public String getSendDiversion() {
		return sendDiversion;
	}

	public void setSendDiversion(String sendDiversion) {
		this.sendDiversion = sendDiversion;
	}

	public String getSendHistoryInfo() {
		return sendHistoryInfo;
	}

	public void setSendHistoryInfo(String sendHistoryInfo) {
		this.sendHistoryInfo = sendHistoryInfo;
	}

	public String getSendPai() {
		return sendPai;
	}

	public void setSendPai(String sendPai) {
		this.sendPai = sendPai;
	}

	public String getSendRpid() {
		return sendRpid;
	}

	public void setSendRpid(String sendRpid) {
		this.sendRpid = sendRpid;
	}

	public String getSetVar() {
		return setVar;
	}

	public void setSetVar(String setVar) {
		this.setVar = setVar;
	}

	public String getSrtpTag32() {
		return srtpTag32;
	}

	public void setSrtpTag32(String srtpTag32) {
		this.srtpTag32 = srtpTag32;
	}

	public String getStirShaken() {
		return stirShaken;
	}

	public void setStirShaken(String stirShaken) {
		this.stirShaken = stirShaken;
	}

	public Integer getSubMinExpiry() {
		return subMinExpiry;
	}

	public void setSubMinExpiry(Integer subMinExpiry) {
		this.subMinExpiry = subMinExpiry;
	}

	public String getSubscribeContext() {
		return subscribeContext;
	}

	public void setSubscribeContext(String subscribeContext) {
		this.subscribeContext = subscribeContext;
	}

	public String getSuppressQ850ReasonHeaders() {
		return suppressQ850ReasonHeaders;
	}

	public void setSuppressQ850ReasonHeaders(String suppressQ850ReasonHeaders) {
		this.suppressQ850ReasonHeaders = suppressQ850ReasonHeaders;
	}

	public String getT38Udptl() {
		return t38Udptl;
	}

	public void setT38Udptl(String t38Udptl) {
		this.t38Udptl = t38Udptl;
	}

	public String getT38UdptlEc() {
		return t38UdptlEc;
	}

	public void setT38UdptlEc(String t38UdptlEc) {
		this.t38UdptlEc = t38UdptlEc;
	}

	public String getT38UdptlIpv6() {
		return t38UdptlIpv6;
	}

	public void setT38UdptlIpv6(String t38UdptlIpv6) {
		this.t38UdptlIpv6 = t38UdptlIpv6;
	}

	public Integer getT38UdptlMaxdatagram() {
		return t38UdptlMaxdatagram;
	}

	public void setT38UdptlMaxdatagram(Integer t38UdptlMaxdatagram) {
		this.t38UdptlMaxdatagram = t38UdptlMaxdatagram;
	}

	public String getT38UdptlNat() {
		return t38UdptlNat;
	}

	public void setT38UdptlNat(String t38UdptlNat) {
		this.t38UdptlNat = t38UdptlNat;
	}

	public String getTimers() {
		return timers;
	}

	public void setTimers(String timers) {
		this.timers = timers;
	}

	public Integer getTimersMinSe() {
		return timersMinSe;
	}

	public void setTimersMinSe(Integer timersMinSe) {
		this.timersMinSe = timersMinSe;
	}

	public Integer getTimersSessExpires() {
		return timersSessExpires;
	}

	public void setTimersSessExpires(Integer timersSessExpires) {
		this.timersSessExpires = timersSessExpires;
	}

	public String getToneZone() {
		return toneZone;
	}

	public void setToneZone(String toneZone) {
		this.toneZone = toneZone;
	}

	public String getTosAudio() {
		return tosAudio;
	}

	public void setTosAudio(String tosAudio) {
		this.tosAudio = tosAudio;
	}

	public String getTosVideo() {
		return tosVideo;
	}

	public void setTosVideo(String tosVideo) {
		this.tosVideo = tosVideo;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getTrustConnectedLine() {
		return trustConnectedLine;
	}

	public void setTrustConnectedLine(String trustConnectedLine) {
		this.trustConnectedLine = trustConnectedLine;
	}

	public String getTrustIdInbound() {
		return trustIdInbound;
	}

	public void setTrustIdInbound(String trustIdInbound) {
		this.trustIdInbound = trustIdInbound;
	}

	public String getTrustIdOutbound() {
		return trustIdOutbound;
	}

	public void setTrustIdOutbound(String trustIdOutbound) {
		this.trustIdOutbound = trustIdOutbound;
	}

	public String getUseAvpf() {
		return useAvpf;
	}

	public void setUseAvpf(String useAvpf) {
		this.useAvpf = useAvpf;
	}

	public String getUsePtime() {
		return usePtime;
	}

	public void setUsePtime(String usePtime) {
		this.usePtime = usePtime;
	}

	public String getUserEqPhone() {
		return userEqPhone;
	}

	public void setUserEqPhone(String userEqPhone) {
		this.userEqPhone = userEqPhone;
	}

	public String getVoicemailExtension() {
		return voicemailExtension;
	}

	public void setVoicemailExtension(String voicemailExtension) {
		this.voicemailExtension = voicemailExtension;
	}

	public String getWebrtc() {
		return webrtc;
	}

	public void setWebrtc(String webrtc) {
		this.webrtc = webrtc;
	}

	
}