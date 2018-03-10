package com.datakettle.spring5demo.repositories;

import com.datakettle.spring5demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String>{


}
