package com.web.web.repo;

import com.web.web.domain.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<TestEntity, Long> {

}
