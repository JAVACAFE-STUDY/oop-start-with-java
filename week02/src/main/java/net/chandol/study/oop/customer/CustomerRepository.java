package net.chandol.study.oop.customer;


import net.chandol.study.oop.infra.Registrar;

public class CustomerRepository {
    public static void persist(Customer customer){
        Registrar.add(customer, Customer.class);
    }

    public static Customer get(String id){
        return Registrar.get(id, Customer.class);
    }
}
