package nl.robertalblas.testfixturesdemo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Title extends BaseEntity {

    private String name;
    private int trackNumber;
    private int duration;

}
