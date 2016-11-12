package net.chandol.study.oop.customer;

import lombok.Data;

@Data
public class CustomerRequest {
    private String email;
    private String password;

    protected CustomerRequest() {
    }

    public CustomerRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
