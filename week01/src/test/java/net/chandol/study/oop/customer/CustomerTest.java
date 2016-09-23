package net.chandol.study.oop.customer;

import net.chandol.study.oop.common.Registrar;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class CustomerTest {

    @Test
    public void aliasProblem() {
        Address fixtureAddress = new Address("경기도", "성남시");
        Customer customer = new Customer("test", "password", "test@test.com", fixtureAddress);

        assertThat(customer.getAddress().getState(), is("경기도"));

        Address address = customer.getAddress();
        Address anotherAddress = address;

        Address engAddress = anotherAddress.asEnglish("Gyunggi-Do", "Seongnam");
        // doSometing using engAddress;

        assertThat(customer.getAddress().getState(), is("경기도"));
    }

    @Test
    public void customerRegistrarTest(){
        CustomerRepository repository = new CustomerRepository();

        Address fixtureAddress = new Address("경기도", "성남시");
        Customer customer = new Customer("test", "password", "test@test.com", fixtureAddress);

        repository.persist(customer);
        Customer anotherCustomer = repository.get("test");

        Set<Customer> all = Registrar.getAll(Customer.class);
        System.out.println(all);

        assertThat(customer, sameInstance(anotherCustomer));
    }

}