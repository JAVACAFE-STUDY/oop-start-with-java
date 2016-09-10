package net.chandol.study.customer;

import net.chandol.study.common.Registrar;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

public class CustomerTest {

    public void setUp() {
        Registrar.init();
    }

    @Test
    public void testCustomerIdentical() {
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = new Customer("CUST-01", "홍길동", "경기도 안양시");
        customerRepository.save(customer);
        Customer anotherCustomer = customerRepository.find("CUST-01");

        assertThat(customer, is(anotherCustomer));
    }

    @Test
    public void testAliasing() {
        Customer customer = new Customer("CUST-01", "홍길동", "경기도 안양시");
        Customer anotherCustomer = customer;

        long price = 1000;
        customer.purchase(price);

        assertEquals(price * 0.01, customer.getMileage(), 0.1);
        //do something
        //expecting assert not equals
        assertNotEquals(0, anotherCustomer.getMileage());
    }

}