package net.chandol.study.oop.store;


import net.chandol.study.oop.store.model.Item;
import net.chandol.study.oop.store.model.Member;
import net.chandol.study.oop.store.repository.ItemRepository;
import net.chandol.study.oop.store.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StoreQueryTest {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 라면상품찾기_테스트() {
        List<Item> items1 = itemRepository.jpqlFindByNameContaining("라면");
        System.out.println(items1);

        List<Item> items2 = itemRepository.findByNameContaining("라면");
        System.out.println(items2);

        List<Item> items3 = itemRepository.queryDslFindByNameContaining("라면");
        System.out.println(items3);
    }

    @Test
    public void 주문존재사용자_찾기_테스트(){
        List<Member> members = memberRepository.findMemberExistOrder();
        System.out.println(members);
    }
}
