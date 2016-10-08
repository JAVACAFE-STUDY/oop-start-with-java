package net.chandol.study.oop.customer;

import net.chandol.study.oop.infra.Registrar;
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
        //given
        Address address = new Address("경기도", "성남시");
        Customer customer = new Customer("test", "password", "test@test.com", address);

        //when
        CustomerRepository.persist(customer);

        //then
        Customer anotherCustomer = CustomerRepository.get("test");
        assertThat(customer, sameInstance(anotherCustomer));


        Set<Customer> all = Registrar.getAll(Customer.class);
        System.out.println(all);
    }


}