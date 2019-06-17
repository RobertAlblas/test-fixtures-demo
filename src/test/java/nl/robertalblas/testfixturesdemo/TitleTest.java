package nl.robertalblas.testfixturesdemo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;

public class TitleTest extends BaseTest {

    @Autowired
    private TitleRepository titleRepository;

    @Test
    public void testSaveTitle() {
        Title title = new Title();
        title.setDuration(214);
        title.setName("Never Gonna Give You Up");
        title.setTrackNumber(1);

        Title savedTitle = titleRepository.save(title);

        assertNotNull(savedTitle.getId().longValue());
        assertEquals(214, savedTitle.getDuration());
        assertEquals("Never Gonna Give You Up", savedTitle.getName());
        assertEquals(1, savedTitle.getTrackNumber());
    }
}
