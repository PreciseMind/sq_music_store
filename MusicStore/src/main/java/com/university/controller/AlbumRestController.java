package com.university.controller;

import com.university.model.Album;
import com.university.model.Song;
import com.university.repository.AlbumRepository;
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
public class AlbumRestController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @RequestMapping(
        value = "/albums",
        method = RequestMethod.GET)
    public List<Album> getAll() {

        List<Album> albums = new ArrayList<>();
        albumRepository.findAll().forEach(albums::add);
        return albums;
    }

    @RequestMapping(
        value = "/albums",
        params = {"id"},
        method = RequestMethod.GET)
    public Album getById(@RequestParam("id") String id) {

        Album album = albumRepository.findById(Long.valueOf(id)).orElse(null);
        return album;
    }

    @RequestMapping(
        value = "/albums",
        params = {"name"},
        method = RequestMethod.GET)
    public List<Album> getByName(@RequestParam("name") String name) {

        List<Album> albums = albumRepository.findByName(name);
        return albums;
    }

    @RequestMapping(
        value = "/albums",
        params = {"authorStageName"},
        method = RequestMethod.GET)
    public List<Album> getByAuthorStageName(
        @RequestParam("authorStageName") String authorStageName) {

        List<Album> albums = albumRepository.findBySongsAuthorStageName(authorStageName);
        return albums;
    }

    @RequestMapping(
        value = "/albums",
        params = {"songId"},
        method = RequestMethod.GET)
    public List<Album> getBySong(@RequestParam("songId") String songId) {

        List<Album> albums = albumRepository.findBySongsId(Long.valueOf(songId));
        return albums;
    }

    @RequestMapping(
        value = "/albums",
        method = RequestMethod.POST)
    public void postAlbum(@RequestBody Album album) {

        album.setSongs(extractExistedSongs(album.getSongs()));
        albumRepository.save(album);
    }

    @RequestMapping(
        value = "/albums",
        params = {"id"},
        method = RequestMethod.DELETE)
    public void deleteById(@RequestParam("id") String id) {

        albumRepository.deleteById(Long.parseLong(id));
    }

    private List<Song> extractExistedSongs(List<Song> detachedSongs) {

        List<Long> ids = detachedSongs.stream().map(Song::getId).collect(Collectors.toList());
        List<Song> songs = songRepository.findByIdIn(ids);

        detachedSongs.stream().forEach(deSong -> {
            if (!songs.contains(deSong)) {
                songs.add(deSong);
            }
        });

        return songs;
    }
}
