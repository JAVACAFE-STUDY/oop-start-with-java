package net.chandol.study.oop.store;

import lombok.Getter;

@Getter
public class Member {
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    public Member(String name, String city, String street, String zipcode) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}