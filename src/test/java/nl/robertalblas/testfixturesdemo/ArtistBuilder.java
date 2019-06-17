package nl.robertalblas.testfixturesdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArtistBuilder {

    @Autowired
    private ArtistRepository artistRepository;

    public Artist buildArtist(String name, List<Album> albums) {
        Artist artist = new Artist();
        artist.setName(name);
        artist.setAlbums(albums);

        return artistRepository.save(artist);
    }
}
