package music_app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    private int id;
    private String name;
    private String performingArtist;
    private String kindOfMusic;
    private String songFilePath;

    public Music() {
    }

    public Music(int id, String name, String performingArtist, String kindOfMusic, String songFilePath) {
        this.id = id;
        this.name = name;
        this.performingArtist = performingArtist;
        this.kindOfMusic = kindOfMusic;
        this.songFilePath = songFilePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerformingArtist() {
        return performingArtist;
    }

    public void setPerformingArtist(String performingArtist) {
        this.performingArtist = performingArtist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getSongFilePath() {
        return songFilePath;
    }

    public void setSongFilePath(String songFilePath) {
        this.songFilePath = songFilePath;
    }
}
