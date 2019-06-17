package nl.robertalblas.testfixturesdemo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;

public class TitleTest extends BaseTest {

    @Autowired
    private TitleBuilder titleBuilder;

    @Test
    public void testSaveTitle() {
        Title savedTitle = titleBuilder.never_gonna_give_you_up();

        assertNotNull(savedTitle.getId());
        assertEquals(214, savedTitle.getDuration());
        assertEquals("Never Gonna Give You Up", savedTitle.getName());
        assertEquals(1, savedTitle.getTrackNumber());
    }
}
