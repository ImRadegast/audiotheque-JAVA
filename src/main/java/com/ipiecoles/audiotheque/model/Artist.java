package com.ipiecoles.audiotheque.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity

public class Artist {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;



    private String name ;

    @OneToMany
    private Set<Album> albums = new HashSet<>();

    public Artist(){

    }

    public Artist(Long id, String name){
        this.name = name;
        this.id= id;
    }
    public Artist(Long id,String name,HashSet<Album> album){
        this.name =name;
        this.id= id;
        this.albums=album;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artist)) return false;
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id) && Objects.equals(name, artist.name) && Objects.equals(albums, artist.albums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, albums);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
