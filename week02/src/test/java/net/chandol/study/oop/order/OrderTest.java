package net.chandol.study.oop.order;

import net.chandol.study.oop.common.Money;
import net.chandol.study.oop.customer.Customer;
import net.chandol.study.oop.customer.CustomerRepository;
import net.chandol.study.oop.product.Product;
import net.chandol.study.oop.product.ProductRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class OrderTest {
    private Customer cust1;
    private Customer cust2;
    private Product 신라면;
    private Product 너구리;
    private Product 짜파게티;

    @Before
    public void setup() {
        cust1 = new Customer("cust1", "p@ssw0rd", "", null);
        cust2 = new Customer("cust2", "p@ssw0rd", "", null);

        신라면 = new Product("1", "신라면", Money.of(650));
        너구리 = new Product("2", "너구리", Money.of(800));
        너구리 = new Product("3", "너구리", Money.of(900));

        CustomerRepository.persist(cust1);
        ProductRepository.persist(신라면);
        ProductRepository.persist(너구리);
    }

    @Test
    public void orderTest() {
        //given
        //when
        Order order = new Order("1", cust1);
        order.addProduct(신라면, 1);
        order.addProduct(너구리, 2);
        order.addProduct(신라면, 1);

        //then
        assertThat(order.getOrderLines().size(), is(2));
        assertThat(order.getTotalAmount(), is(Money.of(2900)));
    }


    @Test
    public void findByCustomerTest() {
        //given
        OrderRepository.persist(new Order("1", cust1));
        OrderRepository.persist(new Order("2", cust1));
        OrderRepository.persist(new Order("3", cust1));
        OrderRepository.persist(new Order("4", cust2));

        //when
        List<Order> customerOrderList = OrderRepository.findByCustomer("cust1");

        //then
        assertThat(customerOrderList.size(), is(3));
        assertThat(customerOrderList.get(0).getCustomer(), is(cust1));
    }
}
