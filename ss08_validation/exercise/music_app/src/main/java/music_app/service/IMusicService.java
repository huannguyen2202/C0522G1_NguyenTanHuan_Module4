package music_app.service;

import music_app.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void save(Music music);

    Music findById(int id);

    void update(Music music);
}
