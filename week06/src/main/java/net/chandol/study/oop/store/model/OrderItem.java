package net.chandol.study.oop.store.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Item item;
    @ManyToOne
    private Order order;
    private int orderPrice; //  가격
    private int count; //수량

    public OrderItem() {
    }

    public OrderItem(Item item, Order order, int orderPrice, int count) {
        this.item = item;
        this.order = order;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", item=" + item +
                ", order=" + order +
                ", orderPrice=" + orderPrice +
                ", count=" + count +
                '}';
    }
}