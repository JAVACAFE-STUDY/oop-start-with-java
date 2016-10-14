package net.chandol.study.oop.store;


import net.chandol.study.oop.store.model.Item;
import net.chandol.study.oop.store.model.Member;
import net.chandol.study.oop.store.model.Order;
import net.chandol.study.oop.store.model.OrderItem;
import net.chandol.study.oop.store.model.type.OrderStatus;
import net.chandol.study.oop.store.repository.ItemRepository;
import net.chandol.study.oop.store.repository.MemberRepository;
import net.chandol.study.oop.store.repository.OrderItemRepository;
import net.chandol.study.oop.store.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StoreTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;

    @Test
    public void 주문생성_테스트(){
        // 사용자를 추가합니다.
        Member member1 = memberRepository.save(new Member("유저1", "email11"));
        Member member2 = memberRepository.save(new Member("유저2", "email22"));

        // 상품을 추가합니다.
        Item item1 = itemRepository.save(new Item("신라면", 800));
        Item item2 = itemRepository.save(new Item("진라면", 700));

        // 사용자에게 주문을 추가합니다.
        Order order = orderRepository.save(new Order(member1.getId(), new Date(), OrderStatus.ORDER));
        OrderItem orderItem1 = orderItemRepository.save(new OrderItem(item1.getId(), order.getId(), 4000, 3));
        OrderItem orderItem2 = orderItemRepository.save(new OrderItem(item2.getId(), order.getId(), 1000, 2));

        // 만들어진 주문에 상품을 추가합니다.

        System.out.println(memberRepository.findAll());
        System.out.println(itemRepository.findAll());
        System.out.println(orderRepository.findAll());
        System.out.println(orderItemRepository.findAll());
    }
}
