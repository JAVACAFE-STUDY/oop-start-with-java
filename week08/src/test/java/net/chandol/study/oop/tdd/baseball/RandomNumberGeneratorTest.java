package net.chandol.study.oop.tdd.baseball;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RandomNumberGeneratorTest {

    @Test
    public void 난수10이하의정수생성테스트() {
        // given
        RandomNumberGenerator generator = new RandomNumberGenerator();

        // when
        int num = generator.generateRandNum();

        // then
        assertTrue(num >= 0 && num <= 9);
    }

    @Test
    public void 세자리의숫자생성테스트() {
        // given
        RandomNumberGenerator generator = new RandomNumberGenerator();

        // when
        Integer[] numbers = generator.generate();

        // then
        assertThat(numbers.length, is(3));
    }

    /**
     * 난수는 테스트할 수 없습니다.
     * 테스트는 언제나 동일한 결과가 반환되는것이 보장되어야 합니다.
     * 난수는 동일한 결과를 보장할 수 없습니다.
     * 테스트의 결과가 일정함을 보장할 수 없습니다.
     */
    @Test
    public void 중복확인하기() {
        // given
        RandomNumberGenerator generator = new RandomNumberGenerator();

        // when, then
        for (int idx = 0; idx < 10; idx++) {
            Integer[] numbers = generator.generate();
            checkHasDuplicateItem(numbers);
        }
    }


    private void checkHasDuplicateItem(Integer[] numbers) {
        Set<Integer> numberSet = new HashSet<>(Arrays.asList(numbers));
        if (numbers.length != numberSet.size()) {
            fail();
        }
    }
}
