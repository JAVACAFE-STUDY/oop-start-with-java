package net.chandol.study.oop.store.repository.custom;

import net.chandol.study.oop.store.model.Item;

import java.util.List;

public interface ItemRepositoryCustom {
    List<Item> queryDslFindByNameContaining(String name);
}
