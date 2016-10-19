package net.chandol.study.oop.store.repository.custom;

import com.querydsl.jpa.JPQLQuery;
import net.chandol.study.oop.store.model.Item;
import net.chandol.study.oop.store.model.QItem;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

public class ItemRepositoryImpl extends QueryDslRepositorySupport implements ItemRepositoryCustom{
    public ItemRepositoryImpl() {
        super(Item.class);
    }

    public List<Item> queryDslFindByNameContaining(String name) {
        QItem item = QItem.item;

        JPQLQuery<Item> query = this.from(item).where(item.name.like("%" + name + "%"));
        return query.fetch();
    }
}
