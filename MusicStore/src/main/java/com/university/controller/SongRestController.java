package com.university.controller;

import com.university.model.Album;
import com.university.model.Author;
import com.university.model.Song;
import com.university.repository.AlbumRepository;
import com.university.repository.AuthorRepository;
import com.university.repository.SongRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongRestController {

    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping("/songs")
    public List<Song> getAll() {

        List<Song> songs = new ArrayList<>();
        songRepository.findAll().forEach(songs::add);
        return songs;
    }

    @RequestMapping(
        value = "/songs",
        params = {"name"})
    public Song getByName(@RequestParam("name") String name) {

        Song song = songRepository.findByName(name);
        return song;
    }

    @RequestMapping(
        value = "/songs",
        params = {"albumName"})
    public List<Song> getByAlbumName(@RequestParam("albumName") String albumName) {

        List<Album> albums = albumRepository.findByName(albumName);

        List<Song> songs = albums.stream().flatMap(album -> album.getSongs().stream())
            .collect(Collectors.toList());

        return songs;
    }

    @RequestMapping(
        value = "/songs",
        params = {"authorStageName"})
    public List<Song> getByAuthorStageName(
        @RequestParam("authorStageName") String authorStageName) {

        List<Song> songs = songRepository.findByAuthorStageName(authorStageName);
        return songs;
    }

    @RequestMapping(
        value = "/songs",
        params = {"id"})
    public Song getById(@RequestParam("id") String id) {

        Song song = songRepository.findById(Long.parseLong(id)).orElse(null);
        return song;
    }

    @RequestMapping(value = "/songs", method = RequestMethod.POST)
    public void postSong(@RequestBody Song song) {

        song.setAuthor(extractExistedAuthors(song.getAuthor()));
        songRepository.save(song);
    }

    @RequestMapping(
        value = "/songs",
        params = {"id"},
        method = RequestMethod.DELETE)
    public void deleteById(@RequestParam("id") String id) {

        songRepository.deleteById(Long.parseLong(id));
    }

    private List<Author> extractExistedAuthors(List<Author> detachedAuthors) {

        List<Long> ids = detachedAuthors.stream().map(Author::getId).collect(Collectors.toList());
        List<Author> authors = authorRepository.findByIdIn(ids);

        detachedAuthors.stream().forEach(deAuthor -> {
            if (!authors.contains(deAuthor)) {
                authors.add(deAuthor);
            }
        });

        return authors;
    }
}
