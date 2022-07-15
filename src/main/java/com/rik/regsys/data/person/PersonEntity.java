package com.rik.regsys.data.person;

import com.rik.regsys.data.event.EventEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "id_code", nullable = false, length = 12)
    private String idCode;

    @Column(name = "payment_method", nullable = false, length = 50)
    private String paymentMethod;

    @Column(name = "extra_info", length = 1500)
    private String extraInfo;

    @ManyToOne
    @JoinColumn(name = "event_entity_id")
    private EventEntity eventEntity;

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idCode='" + idCode + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", extraInfo='" + extraInfo + '\'' +
                ", eventEntity=" + eventEntity +
                '}';
    }
}
