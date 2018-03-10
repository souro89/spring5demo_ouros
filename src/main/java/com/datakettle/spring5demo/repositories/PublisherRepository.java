package com.datakettle.spring5demo.repositories;

import com.datakettle.spring5demo.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher , Long>{

}
