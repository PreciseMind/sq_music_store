package com.university.repository;

import com.university.model.Song;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

    Song findByName(String name);

    List<Song> findByIdIn(List<Long> ids);

    List<Song> findByAuthorStageName(String stageName);


}
