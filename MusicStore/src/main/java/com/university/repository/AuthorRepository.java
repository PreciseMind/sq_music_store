package com.university.repository;

import com.university.model.Author;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findByStageName(String stageName);

    List<Author> findByIdIn(List<Long> ids);

    @Transactional
    void deleteByStageName(String stageName);
}
