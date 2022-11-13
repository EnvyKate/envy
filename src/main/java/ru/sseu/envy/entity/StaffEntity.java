package ru.sseu.envy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "crm", name = "staff")
public class StaffEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID uuid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "hire_date", updatable = false, nullable = false)
    private LocalDate hireDate;
}
