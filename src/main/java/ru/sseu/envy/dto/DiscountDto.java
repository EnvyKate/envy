package ru.sseu.envy.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Setter
@Getter
@Accessors(chain = true)
public class DiscountDto {

    @Setter(AccessLevel.NONE)
    private UUID uuid;

    private Double paymentThreshold;

    private Double discountValue;
}
