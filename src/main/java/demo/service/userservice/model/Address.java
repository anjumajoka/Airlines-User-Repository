package demo.service.userservice.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;


public class Address implements Serializable {
    private long id;
    private String street;
    private String city;
    private String state;
    private String zip;
}
