package com.rik.regsys.data.event;

import com.rik.regsys.data.company.CompanyEntity;
import com.rik.regsys.data.person.PersonEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "event")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "Üritusel peab olema nimi!")
    @Column(name = "event_name", length = 50)
    private String eventName;

    @NotEmpty(message = "Üritusel peab olema asukoht!")
    @Column(name = "location", length = 100)
    private String location;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "extra_info", length = 1000)
    @Length(max = 1000, message = "Lisainfo kogus on üle limiidi! (maksimum 1000 tähemärki)")
    private String extraInfo;

    @OneToMany(mappedBy = "eventEntity", orphanRemoval = true)
    private Set<PersonEntity> personEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "eventEntity", orphanRemoval = true)
    private Set<CompanyEntity> companyEntities = new LinkedHashSet<>();

}
