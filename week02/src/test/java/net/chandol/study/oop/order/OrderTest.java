package net.chandol.study.oop.order;

import net.chandol.study.oop.common.Money;
import net.chandol.study.oop.customer.Customer;
import net.chandol.study.oop.customer.CustomerRepository;
import net.chandol.study.oop.product.Product;
import net.chandol.study.oop.product.ProductRepository;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class OrderTest {
    private Customer customer;
    private Product 신라면;
    private Product 너구리;

    @Before
    public void setup() {
        customer = new Customer("test", "p@ssw0rd", "", null);
        신라면 = new Product("1", "신라면", Money.of(650));
        너구리 = new Product("2", "너구리", Money.of(800));

        CustomerRepository.persist(customer);
        ProductRepository.persist(신라면);
        ProductRepository.persist(너구리);
    }

    @Test
    public void orderTest() {
        Order order = new Order("1", customer);
        order.addProduct(신라면, 1);
        order.addProduct(너구리, 2);
        order.addProduct(신라면, 1);

        assertThat(order.getOrderLines().size(), is(2));
        assertThat(order.getTotalAmount(), is(Money.of(2900)));
    }
}
