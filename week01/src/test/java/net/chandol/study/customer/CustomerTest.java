package net.chandol.study.customer;

import net.chandol.study.common.Registrar;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

public class CustomerTest {

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

    public void setUp() {
        Registrar.init();
    }

    @Test
    public void testCustomerIdentical() {
        Customer customer = new Customer("CUST-01", "홍길동", "경기도 안양시").persist();
        Customer anotherCustomer = Customer.find("CUST-01");
        assertThat(customer, is(anotherCustomer));
    }
}