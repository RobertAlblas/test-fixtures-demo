package nl.robertalblas.testfixturesdemo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class DemoTest extends BaseTest {

    @Autowired
    private ArtistBuilder artistBuilder;

    @Autowired
    private TitleBuilder titleBuilder;

    @Test
    public void testIfTheSameObjectsAreUsed() {
        Title title = titleBuilder.never_gonna_give_you_up();
        Artist rick = artistBuilder.rick_astley();

        // Check if the same genre object is reused
        assertEquals(
          rick.getAlbums().get(0).getGenre().getId(),
          rick.getAlbums().get(1).getGenre().getId()
        );


        Title rolled = rick.getAlbums().stream()
                .flatMap(a -> a.getTitles().stream())
                .filter(t -> t.getName().equals(title.getName()))
                .findFirst().get();

        // Check if the same title object is reused
        assertEquals(
            title.getId(),
            rolled.getId()
        );
    }

}
