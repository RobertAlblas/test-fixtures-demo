package nl.robertalblas.testfixturesdemo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AlbumTest extends BaseTest {

    @Autowired
    private AlbumBuilder albumBuilder;

    @Test
    public void testSaveAlbum() {
        Album savedAlbum = albumBuilder.whenever_you_need_somebody();
        assertNotNull(savedAlbum.getId());
        assertEquals("Whenever You Need Somebody", savedAlbum.getName());
        assertEquals(2203, savedAlbum.getDuration());
        assertEquals(1987, savedAlbum.getYear());
    }

}
