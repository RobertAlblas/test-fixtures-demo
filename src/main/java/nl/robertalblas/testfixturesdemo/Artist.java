package nl.robertalblas.testfixturesdemo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Artist extends BaseEntity {

    private String name;

    @OneToMany
    private List<Album> albums;

    public int getTotalDuration() {
        return albums.stream()
                .mapToInt(album -> album.getTitles().stream()
                    .mapToInt(Title::getDuration).sum())
                .sum();

    }
}
