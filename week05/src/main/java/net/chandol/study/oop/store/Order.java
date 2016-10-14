package net.chandol.study.oop.store;

import lombok.Getter;
import net.chandol.study.oop.store.type.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private Long memberId;
    private Date orderDate; //주문 날짜
    private OrderStatus status;//주문상태

    public Order() {
    }

    public Order(Long memberId, Date orderDate, OrderStatus orderStatus) {
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.status = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", orderDate=" + orderDate +
                ", status=" + status +
                '}';
    }
}