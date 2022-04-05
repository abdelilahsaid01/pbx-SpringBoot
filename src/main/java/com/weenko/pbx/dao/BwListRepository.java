package com.weenko.pbx.dao;

import org.springframework.data.repository.CrudRepository;
import com.weenko.pbx.model.BwEntry;

public interface BwListRepository extends CrudRepository<BwEntry, Long> {

}
