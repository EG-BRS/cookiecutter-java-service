package dk.codezoo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by michael on 07/02/2017.
 */
public enum Kind {
    @JsonProperty("Cat")
    CAT,
    @JsonProperty("Dog")
    DOG,
    @JsonProperty("Fish")
    FISH,
    @JsonProperty("Snake")
    SNAKE
}
