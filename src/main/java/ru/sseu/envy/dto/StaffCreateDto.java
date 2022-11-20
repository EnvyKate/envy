package ru.sseu.envy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
public class StaffCreateDto {

    private String name;

    private UUID qualificationUuid;

    private OffsetDateTime hireDate;
}
