package ru.sseu.envy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * Сушность "Квалификация
 */
@Entity
@Getter
@Setter
@Table(schema = "crm", name = "qualification")
public class QualificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID uuid;

    @PrePersist
    public void init() {
        this.setUuid(UUID.randomUUID());
    }

    /**
     * Наименование квалификации
     */
    @Column(name = "name")
    private String name;

    /**
     * Почасовая ставка, руб/час
     */
    @Column(name = "salary_rate")
    private Double salaryRate;

}
