package net.chandol.study.oop.customer;

import net.chandol.study.oop.common.EntryPoint;
import net.chandol.study.oop.common.Registrar;

public class Customer extends EntryPoint {
    private String username;
    private String password;
    private String email;
    private Address address;

    public Customer(String username, String password, String email, Address address) {
        super(username);
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }


    public Customer persist() {
        Registrar.add(this, Customer.class);
        return this;
    }

    public static Customer find(String identity){
        return Registrar.get(identity, Customer.class);
    }
}
