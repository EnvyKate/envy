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
    /**
     * Уникальный идендификатор процедуры
     */

    @Column(name = "procedure_id", updatable = false, insertable = false)
    private Integer procedureId;

    @ManyToOne
    @JoinColumn(name = "procedure_id")
    private ProcedureEntity procedure;

    /**
     * Уникальный идендификатор квалификации
     */

    @Column(name = "qualification_id", insertable = false, updatable = false)
    private Integer qualificationId;

    @ManyToOne
    @JoinColumn(name = "qualification_id")
    private QualificationEntity qualification;

    /**
     * Цена услуги
     */

    @Column(name = "price")
    private Double price;

    /**
     * Возможность скидки
     */

    @Column(name = "discount_available")
    private boolean discountAvailable;

}
