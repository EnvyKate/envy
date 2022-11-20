package ru.sseu.envy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
public class VisitDto {

    private UUID staffUuid;

    private String staffName;

    private UUID customerUuid;

    private String customerName;

    private UUID procedureUuid;

    private String procedureName;

    private OffsetDateTime visitTime;

    private Double totalPrice;

}
