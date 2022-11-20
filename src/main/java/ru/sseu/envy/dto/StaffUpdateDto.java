package ru.sseu.envy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class StaffUpdateDto {

    private UUID qualificationUuid;

    private String name;
}
