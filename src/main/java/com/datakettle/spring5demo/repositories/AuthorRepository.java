package com.datakettle.spring5demo.repositories;

import com.datakettle.spring5demo.model.Author;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {


}
