package com.unicobib.springframeworkguru.spring_5Webapp.repository;

import com.unicobib.springframeworkguru.spring_5Webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
