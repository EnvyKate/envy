package ru.sseu.envy.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Сущность "Персонал"
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(schema = "crm", name = "staff")
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID uuid;

    /**
     * ФИО
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Дата трудоустройства
     */
    @Column(name = "hire_date", updatable = false, nullable = false)
    private LocalDate hireDate;
    @PrePersist
    public void init() {
        this.setUuid(UUID.randomUUID());
    }

}
