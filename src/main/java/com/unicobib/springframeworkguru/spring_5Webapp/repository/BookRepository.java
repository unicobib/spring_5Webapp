package com.unicobib.springframeworkguru.spring_5Webapp.repository;

import com.unicobib.springframeworkguru.spring_5Webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
