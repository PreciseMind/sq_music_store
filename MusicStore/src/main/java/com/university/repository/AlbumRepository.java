package com.university.repository;

import com.university.model.Album;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

    List<Album> findByName(String name);

    List<Album> findBySongsAuthorStageName(String stageName);

    List<Album> findBySongsId(Long id);
}

