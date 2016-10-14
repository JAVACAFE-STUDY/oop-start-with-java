package net.chandol.study.oop.store;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;
    private Long itemId;
    private Long orderId;
    private int orderPrice; //  가격
    private int count; //수량

    public OrderItem() {
    }

    public OrderItem(Long itemId, Long orderId, int orderPrice, int count) {
        this.itemId = itemId;
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", orderId=" + orderId +
                ", orderPrice=" + orderPrice +
                ", count=" + count +
                '}';
    }
}