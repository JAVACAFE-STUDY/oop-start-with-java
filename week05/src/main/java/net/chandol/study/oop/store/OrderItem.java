package net.chandol.study.oop.store;

import lombok.Getter;

@Getter
public class OrderItem {
    private Long id;
    private Long itemId;
    private Long orderId;
    private int orderPrice; //  가격
    private int count; //수량

    public OrderItem(Long itemId, Long orderId, int orderPrice, int count) {
        this.itemId = itemId;
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.count = count;
    }
}