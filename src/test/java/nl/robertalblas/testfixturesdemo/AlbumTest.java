package nl.robertalblas.testfixturesdemo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AlbumTest extends BaseTest {

    @Autowired
    private AlbumBuilder albumBuilder;

    @Autowired
    private TitleBuilder titleBuilder;

    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void testSaveAlbum() {
        Genre genre = new Genre();
        genre.setName("pop");
        genre = genreRepository.save(genre);

        List<Title> titles = new ArrayList<>();

        titles.add(titleBuilder.createTitle("Never Gonna Give You Up", 1, 214));
        titles.add(titleBuilder.createTitle("Whenever You Need Somebody", 2, 234));
        titles.add(titleBuilder.createTitle("Together Forever", 3, 206));
        titles.add(titleBuilder.createTitle("It Would Take A Strong Strong Man", 4, 221));
        titles.add(titleBuilder.createTitle("The Love Has Gone", 5, 260));
        titles.add(titleBuilder.createTitle("Don't Say Goodbye", 6, 249));
        titles.add(titleBuilder.createTitle("Slipping Away", 7, 193));
        titles.add(titleBuilder.createTitle("No More Looking For Love", 8, 223));
        titles.add(titleBuilder.createTitle("You Move Me", 9, 220));
        titles.add(titleBuilder.createTitle("When I Fall In Love", 10, 183));

        Album savedAlbum = albumBuilder.createAlbum("Whenever you need somebody", 1987, titles, genre);
        assertNotNull(savedAlbum.getId());
        assertEquals("Whenever you need somebody", savedAlbum.getName());
        assertEquals(2203, savedAlbum.getDuration());
        assertEquals(1987, savedAlbum.getYear());
    }

}
