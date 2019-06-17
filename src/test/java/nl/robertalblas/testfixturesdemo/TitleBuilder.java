package nl.robertalblas.testfixturesdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TitleBuilder {

    @Autowired
    private TitleRepository titleRepository;

    public Title createTitle(String name, int trackNumber, int duration) {
        Title title = new Title();
        title.setDuration(duration);
        title.setName(name);
        title.setTrackNumber(trackNumber);

        return titleRepository.save(title);
    }
}
