package nl.robertalblas.testfixturesdemo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Genre extends BaseEntity {

    private String name;
}
