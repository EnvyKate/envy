package ru.sseu.envy.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@Accessors(chain = true)
public class QualificationDto {

    @Setter(AccessLevel.NONE)
    private UUID uuid;

    private String name;

    private Double salaryRate;
}
