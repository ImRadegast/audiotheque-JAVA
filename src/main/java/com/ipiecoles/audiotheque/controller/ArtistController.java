package com.ipiecoles.audiotheque.controller;


import com.ipiecoles.audiotheque.model.Artist;
import com.ipiecoles.audiotheque.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.MediaTypeNotSupportedStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    //Exercice 1
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Artist findArtistById(@PathVariable Long id){
        //Artist artist = artistRepository.findArtistById(id);
       /* if(artist !=null){
            return artist;
        }*/

        Optional<Artist> artist = artistRepository.findById(id);
        if(artist.isPresent()){
            return artist.get();
        }

        throw new EntityNotFoundException("L'Artist d'identifiant " + id + " n'existe pas !");

    }

}
