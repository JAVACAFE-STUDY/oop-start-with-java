package net.chandol.study.customer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CustomerTest {

    @Test
    public void testAliasing() {
        Customer customer = new Customer("CUST-01", "홍길동", "경기도 안양시");
        Customer anotherCustomer = customer;

        long price = 1000;
        customer.purchase(price);

        assertEquals(price * 0.01, customer.getMileage(), 0.1);
        //do something
        //...
        //...
        //...
        //...
        //...
        //...
        //expecting assert not equals
        assertNotEquals(0, anotherCustomer.getMileage());
    }
}