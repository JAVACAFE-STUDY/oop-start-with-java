package net.chandol.study.oop.order;

import net.chandol.study.oop.common.Money;
import net.chandol.study.oop.customer.Customer;
import net.chandol.study.oop.infra.EntryPoint;
import net.chandol.study.oop.product.Product;

import java.util.*;

import static java.util.Collections.unmodifiableList;

public class Order extends EntryPoint {
    private Map<Product,OrderLine> orderLineMap = new HashMap<>();
    private Customer customer;
    private Money totalAmount;

    public Order(String id, Customer customer) {
        super(id);
        this.customer = customer;
    }

    public void addProduct(Product product, int quantity) {
        if(orderLineMap.containsKey(product)){
            OrderLine orderLine = orderLineMap.get(product);
            orderLine.changeQuantity(orderLine.getQuantity() + quantity);
        }else{
            orderLineMap.put(product, new OrderLine(product, quantity));
        }

        calculateTotalAmount();
    }

    private void calculateTotalAmount() {
        int sum = orderLineMap.values().stream()
                .mapToInt(OrderLine::getItemAmount)
                .sum();

        this.totalAmount = Money.of(sum);
    }

    public List<OrderLine> getOrderLines() {
        return unmodifiableList(new ArrayList<>(orderLineMap.values()));
    }

    public Customer getCustomer() {
        return customer;
    }

    public Money getTotalAmount() {
        return totalAmount;
    }
}
