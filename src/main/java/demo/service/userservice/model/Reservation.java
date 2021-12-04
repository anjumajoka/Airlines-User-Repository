package demo.service.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class Reservation implements Serializable {
    private String code;
    private String departure;

    private String destination;

    private Status status = Status.PENDING;

    private Double reserveAmount = 0.0;

    private String reserveBy;

    private Person agent;

    private Person person;

    private String type;

    private List<Ticket> tickets;

    private void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public Reservation(
            String code,
            @NonNull String departure,
            Person agent,
            @NonNull String destination,
            Person person,
            String reserveBy
    ) {
        this.code = code;
        this.departure = departure;
        this.destination = destination;
        this.reserveAmount = 0.0;
        this.agent = agent;
        this.reserveBy = reserveBy;
        this.person = person;
    }
}
