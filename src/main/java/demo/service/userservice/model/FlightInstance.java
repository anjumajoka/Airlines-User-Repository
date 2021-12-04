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

public class FlightInstance implements Serializable {
    private long id;

    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private Long flightId;
    private double amount;

}
