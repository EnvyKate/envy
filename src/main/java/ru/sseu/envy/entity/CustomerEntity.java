package ru.sseu.envy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(schema = "crm", name = "customer")
public class CustomerEntity {

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
     * Номер телефона
     */
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;


    @PrePersist
    public void init() {
        this.setUuid(UUID.randomUUID());
    }

}
