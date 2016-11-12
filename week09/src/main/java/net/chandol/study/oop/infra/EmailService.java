package net.chandol.study.oop.infra;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class EmailService {
    // email을 전송합니다.
    public String sendEmail(String email, String title, String contents) {
        System.out.println("이메일을 전송합니다.");
        System.out.println("email    : " + email);
        System.out.println("title    : " + title);
        System.out.println("contents : " + contents);


        try {
            for (int idx = 0; idx < 3; idx++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(idx + "초 경과");
            }
        } catch (InterruptedException ignored) {
        }
<<<<<<< HEAD:oop-week08/src/main/java/net/chandol/study/oop/infra/EmailService.java

        return "메일전송 성공";
=======
        return "이메일 발송 성공";
>>>>>>> feature/week08_fianl:week08/src/main/java/net/chandol/study/oop/infra/EmailService.java
    }
}
