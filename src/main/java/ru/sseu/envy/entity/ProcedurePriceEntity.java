package ru.sseu.envy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(schema = "crm", name = "procedure_price")
public class ProcedurePriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID uuid;

    @PrePersist
    public void init() {
        this.setUuid(UUID.randomUUID());
    }

    @Column(name = "procedure_id", updatable = false, insertable = false)
    private Integer procedureId;

    @ManyToOne
    @JoinColumn(name = "procedure_id")
    private ProcedureEntity procedure;

    @Column(name = "qualification_id", insertable = false, updatable = false)
    private Integer qualificationId;

    @ManyToOne
    @JoinColumn(name = "qualification_id")
    private QualificationEntity qualification;

    @Column(name = "price")
    private Double price;

    @Column(name = "discount_available")
    private boolean discountAvailable;

}
