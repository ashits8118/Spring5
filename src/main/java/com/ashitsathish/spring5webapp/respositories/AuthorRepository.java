package com.ashitsathish.spring5webapp.respositories;

import com.ashitsathish.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
