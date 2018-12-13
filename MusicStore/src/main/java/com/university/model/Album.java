package com.university.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/*
    {
        "name": "albumT",
        "releaseDate": "01.01.2000",
        "genre": "rock",
        "songs": [
            {
                "id": 1,
                "name": "song1",
                "timeline": 180,
                "createdYear": "2000",
                "author": [
                    {
                        "stageName": "author1",
                        "name": "author-name1",
                        "birthday": "01.01.1995",
                        "country": "Country1",
                        "genre": "rock"
                    }
                ]
            }
        ],
        "isSingleAlbum": false,
        "isDigest": true
    }
 */

@Entity
@Table(name = "ALBUM")
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String releaseDate;

    private Boolean isSingleAlbum;

    private Boolean isDigest;

    private String genre;

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE,
        CascadeType.REFRESH,
        CascadeType.DETACH
    })
    @JoinTable(name = "SONG_ALBUM",
        joinColumns = @JoinColumn(name = "album_id"),
        inverseJoinColumns = @JoinColumn(name = "song_id"),
        foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
        inverseForeignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private List<Song> songs;

    public Album() {
    }

    public Album(String name, String releaseDate, Boolean isSingleAlbum, Boolean isDigest,
        List<Song> songs, String genre) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.isSingleAlbum = isSingleAlbum;
        this.isDigest = isDigest;
        this.songs = songs;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Boolean getSingleAlbum() {
        return isSingleAlbum;
    }

    public Boolean getDigest() {
        return isDigest;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getGenre() {
        return genre;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Album{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", releaseDate='" + releaseDate + '\'' +
            ", isSingleAlbum=" + isSingleAlbum +
            ", isDigest=" + isDigest +
            ", songs=" + songs +
            ", genre='" + genre + '\'' +
            '}';
    }
}
