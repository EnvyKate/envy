package ru.sseu.envy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
public class ProcedureDto {

    private UUID uuid;

    private String name;

    private String description;

    private Integer duration;

}
