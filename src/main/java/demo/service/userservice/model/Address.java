package demo.service.userservice.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Address")
public class Address implements Serializable {
    @Id @GeneratedValue
    private long id;
    @NotNull
    @Size(min = 2, max = 20)
    private String street;
    @NonNull
    @Size(min = 2, max = 20)
    private String city;
    @NonNull
    @Size(min = 2, max = 20)
    private String state;
    @NonNull
    @Size(min = 2, max = 10)
    @Column(unique = true)
    private String zip;
}
