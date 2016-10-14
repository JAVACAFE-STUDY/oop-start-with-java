package net.chandol.study.oop.store;

import lombok.Getter;

@Getter
public class Member {
    private Long id;
    private String name;
    private String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }
}