package net.chandol.study.oop.store;

import lombok.Getter;
import net.chandol.study.oop.store.type.OrderStatus;

import java.util.Date;

@Getter
public class Order {
    private Long id;
    private Long memberId;
    private Date orderDate; //주문 날짜
    private OrderStatus status;//주문상태

    public Order(Long memberId, Date orderDate, OrderStatus status) {
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.status = status;
    }
}