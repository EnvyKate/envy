package ru.sseu.envy.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(schema = "crm", name = "visit_view")
public class VisitViewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID uuid;

    @PrePersist
    public void init() {
        this.setUuid(UUID.randomUUID());
    }

    @Column(name = "visit_time")
    private LocalDateTime visitTime;

    @Column(name = "customer_uuid")
    private UUID customerUuid;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "staff_uuid")
    private UUID staffUuid;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "procedure_uuid")
    private UUID procedureUuid;

    @Column(name = "procedure_name")
    private String procedureName;

    @Column(name = "procedure_price")
    private Double procedurePrice;

    @Column(name = "total_price")
    private Double totalPrice;
}
