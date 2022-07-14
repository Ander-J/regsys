package com.rik.regsys.data.event;

import com.rik.regsys.data.company.CompanyEntity;
import com.rik.regsys.data.person.PersonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "event_name", length = 50)
    private String eventName;

    @Column(name = "location", length = 100)
    private String location;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "extra_info", length = 2500)
    private String extraInfo;

    @Column(name = "is_over")
    private Boolean isOver;

    @OneToMany(mappedBy = "eventEntity", orphanRemoval = true)
    private Set<PersonEntity> personEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "eventEntity", orphanRemoval = true)
    private Set<CompanyEntity> companyEntities = new LinkedHashSet<>();

}
