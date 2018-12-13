package com.university.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
    "name": "songT",
    "timeline": 180,
    "createdYear": "2000",
    "author": [
        {
            "id": 1,
            "stageName": "author1",
            "name": "author-name1",
            "birthday": "01.01.1995",
            "country": "Country1",
            "genre": "rock"
        }
    ]
}
 */

@Entity
@Table(name = "SONG")
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Long timeline;
    private String createdYear;

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE,
        CascadeType.REFRESH,
        CascadeType.DETACH
    })
    @JoinTable(name = "AUTHOR_SONG",
        joinColumns = @JoinColumn(name = "song_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id"),
        foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
        inverseForeignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Fetch(FetchMode.SELECT)
    private List<Author> author;

    public Song() {

    }

    public Song(String name, Long timeline, List<Author> author, String createdYear) {
        this.name = name;
        this.timeline = timeline;
        this.author = author;
        this.createdYear = createdYear;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getTimeline() {
        return timeline;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public String getCreatedYear() {
        return createdYear;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Song song = (Song) o;
        return Objects.equals(id, song.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Song{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", timeline=" + timeline +
            ", author=" + author +
            ", createdYear='" + createdYear + '\'' +
            '}';
    }
}
