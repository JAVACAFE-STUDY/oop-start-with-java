package net.chandol.study.oop.customer;

import net.chandol.study.oop.common.Registrar;

public class CustomerRepository {
    public void persist(Customer customer){
        Registrar.add(customer, Customer.class);
    }

    public Customer get(String identity){
        return Registrar.get(identity, Customer.class);
    }
}
