package com.university.controller;

import com.university.model.Author;
import com.university.repository.AuthorRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorRestController {

    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping(value = "/authors")
    public List<Author> getAll() {

        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().forEach(authors::add);
        return authors;
    }

    @RequestMapping(value = "/authors", params = {"stageName"})
    public Author getByStageName(@RequestParam("stageName") String authorStageName) {

        Author author = authorRepository.findByStageName(authorStageName);
        return author;
    }


    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public void postAuthor(@RequestBody Author author) {
        authorRepository.save(author);
    }

    @RequestMapping(
        value = "/authors",
        params = {"stageName"},
        method = RequestMethod.DELETE)
    public void deleteByStageName(@RequestParam("stageName") String authorStageName) {

        authorRepository.deleteByStageName(authorStageName);
    }
}
