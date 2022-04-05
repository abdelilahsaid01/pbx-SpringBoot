package com.weenko.pbx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weenko.pbx.dao.ChannelRepository;
import com.weenko.pbx.dao.PsAorRepository;
import com.weenko.pbx.dao.PsAuthRepository;
import com.weenko.pbx.dao.PsEndpointRepository;
import com.weenko.pbx.model.Channel;
import com.weenko.pbx.model.PsAor;
import com.weenko.pbx.model.PsAuth;
import com.weenko.pbx.model.PsEndpoint;

@Service
public class ChannelService {

	static final String CONTEXT = "sets";
	
	@Autowired
	PsAorRepository psAorRepository;
	
	@Autowired
	PsAuthRepository psAuthRepository;
	
	@Autowired
	PsEndpointRepository psEndpointRepository;
	
	@Autowired
	ChannelRepository channelRepository;
	
	public boolean saveExistingChannel(Channel channel) {
		Channel oldChannel = channelRepository.findById(channel.getId()).get();
		if(!channel.getUsername().equals(oldChannel.getUsername())) {
			psAorRepository.deleteById(oldChannel.getUsername());
			psAorRepository.save(new PsAor(oldChannel.getUsername()));
			psEndpointRepository.deleteById(oldChannel.getUsername());
			psEndpointRepository.save(new PsEndpoint(oldChannel.getUsername()));
			
			psAuthRepository.deleteById(oldChannel.getUsername());
			psAuthRepository.save(new PsAuth(oldChannel.getUsername(), channel.getPassword(), oldChannel.getPassword()));
		} else {
			if(channel.getPassword() != null && channel.getPassword().length() > 0) {
				PsAuth psAuth = psAuthRepository.findById(oldChannel.getUsername()).get();
				psAuth.setPassword(channel.getPassword());
				psAuthRepository.save(psAuth);
			}
		}
		
		oldChannel.copyFrom(channel);
		
		channelRepository.save(oldChannel);
		
		return true;
	}
	
	public boolean createNewChannel(Channel channel) {
		psAorRepository.save(new PsAor(channel.getUsername()));
		psEndpointRepository.save(new PsEndpoint(channel.getUsername()));
		psAuthRepository.save(new PsAuth(channel.getUsername(), channel.getPassword(), channel.getPassword()));

		channelRepository.save(channel);

		return true;
	}
	
	public boolean deleteExistingChannel(Channel channel) {
		psAorRepository.deleteById(channel.getUsername());
		psEndpointRepository.deleteById(channel.getUsername());
		psAuthRepository.deleteById(channel.getUsername());

		channelRepository.delete(channel);

		return true;
	}
}
