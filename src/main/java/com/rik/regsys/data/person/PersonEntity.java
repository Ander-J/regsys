package com.rik.regsys.data.person;

import com.rik.regsys.data.event.EventEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "Eesnimi on puudu!")
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @NotEmpty(message = "Perenimi on puudu!")
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @NotEmpty(message = "Isikukood on puudu!")
    @Length(min = 11, max = 11, message = "Isikukood on vale!")
    @Column(name = "id_code", nullable = false, length = 11)
    private String idCode;

    @Column(name = "payment_method", nullable = false, length = 50)
    private String paymentMethod;

    @Column(name = "extra_info", length = 1500)
    @Length(max = 1500, message = "Lisainfo kogus on üle limiidi! (maksimum 1500 tähemärki)")
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
