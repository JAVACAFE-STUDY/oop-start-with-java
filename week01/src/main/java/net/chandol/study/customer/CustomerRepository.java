package net.chandol.study.customer;

import net.chandol.study.common.Registrar;

public class CustomerRepository {
 
public void save(Customer customer) {
       Registrar.add(Customer.class, customer);
}
 
public Customer find(String identity) {
       return (Customer)Registrar.get(Customer.class, identity);
}
}