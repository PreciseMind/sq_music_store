package com.university.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*  Example request body
    {
        "stageName": "author2",
        "name": "author-name2",
        "birthday": "01.01.1995",
        "country": "Country2",
        "genre": "rock"
    }
 */
@Entity
@Table(name = "AUTHOR")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String stageName;
    private String name;
    private String birthday;
    private String country;
    private String genre;

    public Author() {
    }

    public Author(String stageName, String name, String birthday, String country,
        String genre) {
        this.stageName = stageName;
        this.name = name;
        this.birthday = birthday;
        this.country = country;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getStageName() {
        return stageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Author{" +
            "stageName='" + stageName + '\'' +
            ", name='" + name + '\'' +
            ", birthday='" + birthday + '\'' +
            ", country='" + country + '\'' +
            ", genre='" + genre + '\'' +
            '}';
    }
}
