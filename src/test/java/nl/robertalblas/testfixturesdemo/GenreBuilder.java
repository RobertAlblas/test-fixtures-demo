package nl.robertalblas.testfixturesdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenreBuilder {

    @Autowired
    private GenreRepository genreRepository;

    public Genre findOrCreate(String name) {
        return genreRepository.findByName(name)
                .orElseGet(() -> {
                    Genre genre = new Genre();
                    genre.setName(name);
                    return genreRepository.save(genre);
                });
    }

    public Genre pop() {
        return findOrCreate("pop");
    }
}
