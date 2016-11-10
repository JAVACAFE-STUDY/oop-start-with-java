package net.chandol.study.oop.customer;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Customer {
    @Id
    @GeneratedValue
    public Long id;
    public String email;
    public String password;

    protected Customer() {
    }

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
