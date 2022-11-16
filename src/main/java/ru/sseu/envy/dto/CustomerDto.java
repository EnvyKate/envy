package ru.sseu.envy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Setter
@Getter
@Accessors(chain = true)
public class CustomerDto {

    private UUID uuid;

    private String name;

    private String phoneNumber;
}
