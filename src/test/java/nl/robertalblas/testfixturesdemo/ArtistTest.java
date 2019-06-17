package nl.robertalblas.testfixturesdemo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ArtistTest extends BaseTest {

    @Autowired
    private ArtistBuilder artistBuilder;

    @Autowired
    private AlbumBuilder albumBuilder;

    @Autowired
    private TitleBuilder titleBuilder;

    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void saveArtist() {
        Genre genre = new Genre();
        genre.setName("pop");
        genre = genreRepository.save(genre);

        List<Title> album1Titles = new ArrayList<>();
        album1Titles.add(titleBuilder.createTitle("Never Gonna Give You Up", 1, 214));
        album1Titles.add(titleBuilder.createTitle("Whenever You Need Somebody", 2, 234));
        album1Titles.add(titleBuilder.createTitle("Together Forever", 3, 206));
        album1Titles.add(titleBuilder.createTitle("It Would Take A Strong Strong Man", 4, 221));
        album1Titles.add(titleBuilder.createTitle("The Love Has Gone", 5, 260));
        album1Titles.add(titleBuilder.createTitle("Don't Say Goodbye", 6, 249));
        album1Titles.add(titleBuilder.createTitle("Slipping Away", 7, 193));
        album1Titles.add(titleBuilder.createTitle("No More Looking For Love", 8, 223));
        album1Titles.add(titleBuilder.createTitle("You Move Me", 9, 220));
        album1Titles.add(titleBuilder.createTitle("When I Fall In Love", 10, 183));

        Album album1 = albumBuilder.createAlbum("Whenever You Need Somebody", 1987, album1Titles, genre);

        List<Title> album2Titles = new ArrayList<>();
        album2Titles.add(titleBuilder.createTitle("She Wants To Dance With Me", 1, 214));
        album2Titles.add(titleBuilder.createTitle("Take Me To Your Heart", 2, 285));
        album2Titles.add(titleBuilder.createTitle("I Don't Want To Lose Her", 3, 189));
        album2Titles.add(titleBuilder.createTitle("Giving Up On Love", 4, 230));
        album2Titles.add(titleBuilder.createTitle("Ain't Too Proud To Beg", 5, 210));
        album2Titles.add(titleBuilder.createTitle("Till Then", 6, 232));
        album2Titles.add(titleBuilder.createTitle("Dial My Number", 7, 201));
        album2Titles.add(titleBuilder.createTitle("I'll Never Let You Down", 8, 214));
        album2Titles.add(titleBuilder.createTitle("I Don't Want To Be Your Lover", 9, 301));
        album2Titles.add(titleBuilder.createTitle("Hold Me In Your Arms", 10, 171));

        Album album2 = albumBuilder.createAlbum("Hold Me In Your Arms", 1988, album2Titles, genre);

        Artist savedArtist = artistBuilder.buildArtist("Rick Astley", asList(album1, album2));

        assertEquals(4450 , savedArtist.getTotalDuration());
        assertEquals("Rick Astley", savedArtist.getName());

    }



}
