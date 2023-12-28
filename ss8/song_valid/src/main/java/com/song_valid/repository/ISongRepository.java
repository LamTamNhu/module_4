package com.song_valid.repository;

import com.song_valid.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface ISongRepository extends CrudRepository<Song,Long> {
}
