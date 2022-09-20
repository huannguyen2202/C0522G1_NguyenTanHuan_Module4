package music_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import music_app.model.Music;

public interface IMusicRepository extends JpaRepository<Music, Integer> {
    Music findById(int id);
}
