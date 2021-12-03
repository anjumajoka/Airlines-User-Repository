package demo.service.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    @Size(min = 2, max = 20)
    private String firstName;
    @NonNull
    @Size(min = 2, max = 20)
    private String lastName;
    @Email
    @NonNull
    private String emailAddress;

    @Column(unique = true)
    @NonNull
    private String username;

    @Size(min = 2, max = 100)
    @JsonIgnore
    private String password;
    @Past
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Address address;

}

