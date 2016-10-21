package net.chandol.study.oop.board.model;

import lombok.Getter;

@Getter
public class User {
    private Long id;
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
