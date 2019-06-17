package nl.robertalblas.testfixturesdemo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Album extends BaseEntity {

    private String name;
    private int year;

    @OneToMany
    private List<Title> titles;

    @ManyToOne
    private Genre genre;

    public int getDuration() {
        return titles.stream().mapToInt(Title::getDuration).sum();
    }
}
