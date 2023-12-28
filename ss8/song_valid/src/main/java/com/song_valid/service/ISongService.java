package com.song_valid.service;

import com.song_valid.model.Song;

public interface ISongService {
    void save(Song song);

    Iterable<Song> getAll();

    Song getById(Long id);
}
