package net.chandol.study.oop.tdd.baseball;

public class MockNumberGenerator implements NumberGenerator{
    private Integer[] numbers;

    public MockNumberGenerator(Integer... numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer[] generate() {
        return numbers;
    }
}
