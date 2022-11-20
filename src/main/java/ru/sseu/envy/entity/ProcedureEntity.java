package ru.sseu.envy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * Сущность "Предоставляемая клиенту услуга"
 */
@Entity
@Getter
@Setter
@Table(schema = "crm", name = "procedure")
public class ProcedureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID uuid;

    @PrePersist
    public void init() {
        this.setUuid(UUID.randomUUID());
    }

    /**
     * Наименование услуги
     */
    @Column(name = "name")
    private String name;

    /**
     * Описание услуги
     */
    @Column(name = "description")
    private String description;

    /**
     * Длительность услуги (в минутах)
     */
    @Column(name = "duration")
    private Integer duration;

}
