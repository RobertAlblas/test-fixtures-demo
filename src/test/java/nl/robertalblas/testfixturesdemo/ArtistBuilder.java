package nl.robertalblas.testfixturesdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class ArtistBuilder {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumBuilder albumBuilder;

    public Artist findOrCreateArtist(String name, List<Album> albums) {
        return artistRepository.findByName(name)
                .orElseGet(() -> {
                    Artist artist = new Artist();
                    artist.setName(name);
                    artist.setAlbums(albums);

                    return artistRepository.save(artist);
                });
    }

    public Artist rick_astley() {
        return findOrCreateArtist("Rick Astley", asList(albumBuilder.whenever_you_need_somebody(), albumBuilder.hold_me_in_your_arms()));
    }
}
