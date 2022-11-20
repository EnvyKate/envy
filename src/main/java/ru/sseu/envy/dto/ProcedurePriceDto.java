package ru.sseu.envy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
public class ProcedurePriceDto {

    private UUID procedureUuid;

    private String procedureName;

    private UUID qualificationUuid;

    private String qualificationName;

    private Double price;

    private boolean discountAvailable;

}
