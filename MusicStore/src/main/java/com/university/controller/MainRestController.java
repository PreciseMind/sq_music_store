package com.university.controller;

import com.university.repository.AlbumRepository;
import com.university.repository.AuthorRepository;
import com.university.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @RequestMapping(value = "/main", method = RequestMethod.DELETE)
    public void deleteAll() {

        albumRepository.deleteAll();
        songRepository.deleteAll();
        authorRepository.deleteAll();
    }
}
