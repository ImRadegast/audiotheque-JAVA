package com.ipiecoles.audiotheque.repository;

import com.ipiecoles.audiotheque.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    //@Query(value = "SELECT * FROM artist WHERE artist.id = id" , nativeQuery = true)
    //Artist findArtistById(Long id);
}
