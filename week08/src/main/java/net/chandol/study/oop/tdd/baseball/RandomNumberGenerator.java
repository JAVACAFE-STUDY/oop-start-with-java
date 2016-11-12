package net.chandol.study.oop.tdd.baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public Integer[] generate() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 3) {
            numbers.add(generateRandNum());
        }

        return numbers.toArray(new Integer[]{});
    }


    int generateRandNum() {
        return (new Random()).nextInt(10);
    }
}
