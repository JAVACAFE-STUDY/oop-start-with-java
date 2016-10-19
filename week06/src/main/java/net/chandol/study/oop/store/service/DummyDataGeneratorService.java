package net.chandol.study.oop.store.service;

import net.chandol.study.oop.store.model.Item;
import net.chandol.study.oop.store.model.Member;
import net.chandol.study.oop.store.model.Order;
import net.chandol.study.oop.store.model.OrderItem;
import net.chandol.study.oop.store.model.type.OrderStatus;
import net.chandol.study.oop.store.repository.ItemRepository;
import net.chandol.study.oop.store.repository.MemberRepository;
import net.chandol.study.oop.store.repository.OrderItemRepository;
import net.chandol.study.oop.store.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DummyDataGeneratorService {
    @Autowired ItemRepository itemRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired OrderItemRepository orderItemRepository;
    @Autowired OrderRepository orderRepository;

    @PostConstruct
    public void generate(){
        List<Item> items = new ArrayList<Item>(){{
            add(new Item("신라면", 800));
            add(new Item("진라면", 700));
            add(new Item("참깨라면", 1200));
            add(new Item("육개장", 600));
            add(new Item("삼양라면", 700));
            add(new Item("비빔면", 1000));
            add(new Item("너구리", 800));
            add(new Item("꼬꼬면", 700));
            add(new Item("오징어 짬뽕", 900));
            add(new Item("짜파게티", 1000));
        }};

        itemRepository.save(items);

        List<Member> members = new ArrayList<Member>(){{
            add(new Member("박세종", "devsejong@chandol.net"));
            add(new Member("서지암", "jiam@chandol.net"));
            add(new Member("강현정", "hyunjung@chandol.net"));
            add(new Member("엄태진", "taejin@chandol.net"));
        }};

        memberRepository.save(members);

        List<Order> orders = new ArrayList<Order>(){{
            add(new Order(members.get(0), new Date(), OrderStatus.ORDER));
            add(new Order(members.get(0), new Date(), OrderStatus.ORDER));
            add(new Order(members.get(2), new Date(), OrderStatus.ORDER));
        }};

        orderRepository.save(orders);

        List<OrderItem> orderItems = new ArrayList<OrderItem>(){{
            add(new OrderItem(items.get(0), orders.get(0), 1000, 3));
            add(new OrderItem(items.get(1), orders.get(0), 2000, 1));
            add(new OrderItem(items.get(2), orders.get(0), 3000, 3));

            add(new OrderItem(items.get(4), orders.get(2), 3000, 3));
            add(new OrderItem(items.get(6), orders.get(2), 5000, 2));
        }};

        orderItemRepository.save(orderItems);
    }
}
