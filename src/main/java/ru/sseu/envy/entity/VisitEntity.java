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
@Table(schema = "crm", name = "visit")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID uuid;

    @PrePersist
    public void init() {
        this.setUuid(UUID.randomUUID());
    }

    @Column(name = "staff_id", updatable = false, insertable = false)
    private Integer staffId;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;

    @Column(name = "customer_id", updatable = false, insertable = false)
    private Integer customerId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @Column(name = "procedure_id", insertable = false, updatable = false)
    private Integer procedureId;

    @ManyToOne
    @JoinColumn(name = "procedure_id")
    private ProcedureEntity procedure;

    @Column(name = "visit_time")
    private LocalDateTime visitTime;

}
