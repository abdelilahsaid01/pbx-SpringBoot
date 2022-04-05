package com.weenko.pbx.dao;

import org.springframework.data.repository.CrudRepository;

import com.weenko.pbx.model.Recharge;

public interface RechargeRepository extends CrudRepository<Recharge, Long> {
	public long countByActive(boolean active);
}
