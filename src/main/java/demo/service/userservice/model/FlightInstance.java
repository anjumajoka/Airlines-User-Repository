package demo.service.userservice.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
public class FlightInstance implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private LocalTime departureTime;
    @NotNull
    private LocalTime arrivalTime;
    @NotNull
    @Future
    private LocalDate departureDate;
    @NotNull
    @Future
    private LocalDate arrivalDate;

    @NotNull
    private Long flightId;

    @NotNull
    private double amount;

}
