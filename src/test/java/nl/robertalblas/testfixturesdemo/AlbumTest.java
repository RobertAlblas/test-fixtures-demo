package nl.robertalblas.testfixturesdemo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AlbumTest extends BaseTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void testSaveAlbum() {
        Genre genre = new Genre();
        genre.setName("pop");
        genre = genreRepository.save(genre);

        Album album = new Album();
        album.setGenre(genre);
        album.setName("Whenever you need somebody");
        album.setYear(1987);
        album.setTitles(new ArrayList<>());

        album.getTitles().add(createTitle("Never Gonna Give You Up", 1, 214));
        album.getTitles().add(createTitle("Whenever You Need Somebody", 2, 234));
        album.getTitles().add(createTitle("Together Forever", 3, 206));
        album.getTitles().add(createTitle("It Would Take A Strong Strong Man", 4, 221));
        album.getTitles().add(createTitle("The Love Has Gone", 5, 260));
        album.getTitles().add(createTitle("Don't Say Goodbye", 6, 249));
        album.getTitles().add(createTitle("Slipping Away", 7, 193));
        album.getTitles().add(createTitle("No More Looking For Love", 8, 223));
        album.getTitles().add(createTitle("You Move Me", 9, 220));
        album.getTitles().add(createTitle("When I Fall In Love", 10, 183));

        Album savedAlbum = albumRepository.save(album);
        assertNotNull(savedAlbum.getId());
        assertEquals("Whenever you need somebody", savedAlbum.getName());
        assertEquals(2203, savedAlbum.getDuration());
        assertEquals(1987, savedAlbum.getYear());
    }

    private Title createTitle(String name, int trackNumber, int duration) {
        Title title = new Title();
        title.setDuration(duration);
        title.setName(name);
        title.setTrackNumber(trackNumber);

        return titleRepository.save(title);
    }

}
