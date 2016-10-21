package net.chandol.study.oop.store.model;

import lombok.Getter;
import net.chandol.study.oop.store.model.type.OrderStatus;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Member member;
    private Date orderDate; //주문 날짜
    private OrderStatus status;//주문상태

    public Order() {
    }

    public Order(Member member, Date orderDate, OrderStatus orderStatus) {
        this.orderDate = orderDate;
        this.status = orderStatus;
        setMember(member);
    }

    public void setMember(Member member) {
        this.member = member;
        member.addOrder(this);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", member=" + member +
                ", orderDate=" + orderDate +
                ", status=" + status +
                '}';
    }
}