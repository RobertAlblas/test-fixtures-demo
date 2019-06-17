package nl.robertalblas.testfixturesdemo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class ArtistTest extends BaseTest {

    @Autowired
    private ArtistBuilder artistBuilder;

    @Test
    public void saveArtist() {
        Artist savedArtist = artistBuilder.rick_astley();

        assertEquals(4450 , savedArtist.getTotalDuration());
        assertEquals("Rick Astley", savedArtist.getName());

    }

}
