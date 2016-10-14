package net.chandol.study.oop.store;

import lombok.Getter;

@Getter
public class Item {
    private Long id;
    private String name; //이름
    private int price; //가격

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
}