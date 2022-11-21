package ru.sseu.envy.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * Сушность "Скидка на предоставляемые услуги"
 */
@Entity
@Getter
@Setter
@Table(schema = "crm", name = "discount")
public class DiscountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID uuid;

    @PrePersist
    public void init() {
        this.setUuid(UUID.randomUUID());
    }

    /**
     * Нижний порог суммы для скидки
     */
    @Column(name = "payment_threshold")
    private Double paymentThreshold;

    /**
     * Размер скидки (множитель на стоимость услуги)
     */
    @Column(name = "discount_value")
    private Double discountValue;

}
