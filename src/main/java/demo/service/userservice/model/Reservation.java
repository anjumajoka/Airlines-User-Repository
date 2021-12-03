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

@Data
@NoArgsConstructor
@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    @Column(unique = true)
    @Size(min = 6, max = 6)
    private String code;
    @NonNull
    @Size(min = 2, max = 20)
    private String departure;

    @NonNull
    @Size(min = 2, max = 20)
    private String destination;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    private Double reserveAmount = 0.0;

    private String reserveBy;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "agent_id")
    private Person agent;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "passenger_Id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Person person;

    @Transient
    private String type;

    @OneToMany(cascade = {CascadeType.ALL})
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
