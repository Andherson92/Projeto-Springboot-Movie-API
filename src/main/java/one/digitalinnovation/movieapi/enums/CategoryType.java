package one.digitalinnovation.movieapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryType {

    ACTION("Acao"),
    ADVENTURE("Aventura"),
    COMEDY("Commercial");

    private final String description;

}
