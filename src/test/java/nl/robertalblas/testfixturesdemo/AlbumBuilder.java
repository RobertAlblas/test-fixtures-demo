package nl.robertalblas.testfixturesdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlbumBuilder {

    @Autowired
    private AlbumRepository albumRepository;

    public Album createAlbum(String name, int year, List<Title> titles, Genre genre) {
        Album album = new Album();
        album.setName(name);
        album.setYear(year);
        album.setTitles(titles);
        album.setGenre(genre);

        return albumRepository.save(album);
    }
}
