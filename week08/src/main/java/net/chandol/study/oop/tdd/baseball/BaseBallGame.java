package net.chandol.study.oop.tdd.baseball;

import static net.chandol.study.oop.tdd.baseball.BaseBallResult.notOutResult;
import static net.chandol.study.oop.tdd.baseball.BaseBallResult.outResult;

public class BaseBallGame {
    private final int a, b, c;

    private NumberGenerator generator;

    public BaseBallGame(NumberGenerator generator) {
        this.generator = generator;

        Integer[] num = this.generator.generate();

        this.a = num[0];
        this.b = num[1];
        this.c = num[2];
    }

    public BaseBallResult check(String source) {
        verifyAllNumbers(source);
        verifyStringLengthIsThree(source);

        int[] n = getNumbers(source);
        verfiyHasDuplicateNumber(n);

        int strike = getStrike(n);
        int ball = getBall(n);

        if (isOut(strike, ball))
            return outResult();
        else
            return notOutResult(strike, ball);
    }


    private boolean isOut(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

    private int getBall(int[] n) {
        int ball = 0;

        if (n[0] == b || n[0] == c)
            ball += 1;

        if (n[1] == a || n[1] == c)
            ball += 1;

        if (n[2] == a || n[2] == b)
            ball += 1;
        return ball;
    }

    private int getStrike(int[] n) {
        int strike = 0;

        if (n[0] == a)
            strike += 1;

        if (n[1] == b)
            strike += 1;

        if (n[2] == c)
            strike += 1;
        return strike;
    }

    private int[] getNumbers(String source) {
        int[] n = new int[3];
        n[0] = Integer.parseInt(source.substring(0, 1));
        n[1] = Integer.parseInt(source.substring(1, 2));
        n[2] = Integer.parseInt(source.substring(2, 3));
        return n;
    }

    private void verfiyHasDuplicateNumber(int[] numbers) {
        if (numbers[0] == numbers[1] || numbers[1] == numbers[2] || numbers[0] == numbers[2]) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    private void verifyStringLengthIsThree(String source) {
        if (source.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자가 들어와야 합니다.");
        }
    }

    private void verifyAllNumbers(String source) {
        try {
            Integer.parseInt(source);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
