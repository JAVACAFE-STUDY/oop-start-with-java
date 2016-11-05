package net.chandol.study.oop.tdd.calculator;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if(b==0)
            throw new IllegalArgumentException("분모는 0이 될 수 없습니다.");

        return a / b;
    }
}
