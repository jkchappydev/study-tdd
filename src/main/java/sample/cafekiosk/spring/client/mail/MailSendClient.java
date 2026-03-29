package sample.cafekiosk.spring.client.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MailSendClient {

    public boolean sendEmail(String fromEmail, String toEmail, String subject, String content) {
        // 메일 전송
        log.info("메일 전송");
        // 테스트 할때는 실제 메일은 보내지 않고 예외를 던져서, 테스트에서 stubbing 처리한다.
        throw new IllegalArgumentException("메일 전송");
    }

}
