package com.rik.regsys.data.company;

import com.rik.regsys.data.event.EventEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "company_name", length = 100)
    private String companyName;

    @Column(name = "reg_code", length = 15)
    private String regCode;

    @Column(name = "attendants")
    private Integer attendants;

    @Column(name = "payment_method", length = 50)
    private String paymentMethod;

    @Column(name = "extra_info", length = 5000)
    private String extraInfo;

    @ManyToOne
    @JoinColumn(name = "event_entity_id")
    private EventEntity eventEntity;

}
