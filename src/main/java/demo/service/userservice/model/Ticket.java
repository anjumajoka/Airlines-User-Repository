package demo.service.userservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@Data
@Entity
public class Ticket implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Column(unique = true)
    @Digits(fraction = 0, integer = 20)
    private String number;

    @NonNull
    @OneToOne
    private FlightInstance flightInstance;

}
