package com.ipiecoles.audiotheque.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Artist artist;

    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Album() {

    }

    public Album(Artist artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", artist=" + artist +
                ", title=" + title +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;
        Album album = (Album) o;
        return id.equals(album.id) && artist.equals(album.artist) && title.equals(album.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artist, title);
    }
}
