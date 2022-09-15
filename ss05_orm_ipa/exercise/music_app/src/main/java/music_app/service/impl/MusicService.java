package music_app.service.impl;

import music_app.model.Music;
import music_app.repository.IMusicRepository;
import music_app.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    IMusicRepository iMusicRepository;
    @Override
    public List<Music> findAll() {

        return iMusicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id);
    }

    @Override
    public void update(Music music) {
        iMusicRepository.update(music);
    }

    @Override
    public void remove(int id) {
        iMusicRepository.remove(id);
    }

}
