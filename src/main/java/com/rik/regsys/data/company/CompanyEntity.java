package com.rik.regsys.data.company;

import com.rik.regsys.data.event.EventEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "company")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "Firmanimi on puudu!")
    @Column(name = "company_name", length = 100)
    private String companyName;

    @NotEmpty(message = "Registrikood on puudu!")
    @Column(name = "reg_code", length = 15)
    private String regCode;

    @NotNull(message = "Osavõtjate arv on puudu!")
    @Column(name = "attendants")
    private Integer attendants;

    @Column(name = "payment_method", length = 50)
    private String paymentMethod;

    @Column(name = "extra_info", length = 5000)
    @Length(max = 5000, message = "Lisainfo kogus on üle limiidi! (maksimum 5000 tähemärki)")
    private String extraInfo;

    @ManyToOne
    @JoinColumn(name = "event_entity_id")
    private EventEntity eventEntity;

}
