package demo.service.userservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Ticket implements Serializable {
    private long id;

    private String number;

    private FlightInstance flightInstance;

}
