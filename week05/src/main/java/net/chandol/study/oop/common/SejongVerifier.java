package net.chandol.study.oop.common;

import static java.util.Objects.isNull;

// 검증 로직이 들어갈 수 있어야 한다.
public final class SejongVerifier {

    public static void verifyNotNull(Object object) {
        verifyNotNull(object, "null은 허용되지 않습니다.");
    }

    public static void verifyNotNull(Object object, String message) {
        if (isNull(object)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void verifyNotEmpty(String target){
        verifyNotNull(target);

        if(target.length() == 0)
            throw new IllegalArgumentException("비어있는 문자열 에러");
    }
}
