package dk.codezoo.model;

import dk.codezoo.common.service.util.BaseEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Pet extends BaseEntity {

    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    @NotNull
    private Kind kind;

    public Pet() {}

    public Pet(String name, Kind kind) {
        this.name = name;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }
}
