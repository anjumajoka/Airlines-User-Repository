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

public abstract class Person implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    private String username;

    private String password;
    private LocalDate dateOfBirth;
    private Role role;

    private Address address;

}

