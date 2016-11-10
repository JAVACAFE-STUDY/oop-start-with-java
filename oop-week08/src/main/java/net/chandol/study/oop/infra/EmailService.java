package net.chandol.study.oop.infra;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class EmailService {
    // email을 전송합니다.
    public void sendEmail(String email, String title, String contents) {
        System.out.println("이메일을 전송합니다.");
        System.out.println("email    : " + email);
        System.out.println("title    : " + title);
        System.out.println("contents : " + contents);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
        }
    }
}
