package net.chandol.study.oop.customer;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void aliasProblem(){
        Address fixtureAddress = new Address("경기도", "성남시");
        Customer customer = new Customer("test", "password", "test@test.com", fixtureAddress);

        Assert.assertThat(customer.getAddress().getState(), CoreMatchers.is("경기도"));

        Address address = customer.getAddress();
        Address anotherAddress = address;

        Address engAddress = anotherAddress.asEnglish("Gyunggi-Do", "Seongnam");
        // doSometing using engAddress;

        Assert.assertThat(customer.getAddress().getState(), CoreMatchers.is("경기도"));
    }

}