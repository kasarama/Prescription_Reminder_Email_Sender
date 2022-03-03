package cph.databases.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
//@Table(name = "address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private int zipcode;

    // Constructors
    public Address() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public int getZipcode() {
        return zipcode;
    }


}
