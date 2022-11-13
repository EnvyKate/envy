package ru.sseu.envy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
public class StaffDto {

    private UUID uuid;

    private String name;

    private OffsetDateTime hireDate;
}
