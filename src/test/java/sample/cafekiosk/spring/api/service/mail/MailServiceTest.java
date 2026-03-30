package sample.cafekiosk.spring.api.service.mail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import sample.cafekiosk.spring.client.mail.MailSendClient;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistory;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistoryRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MailServiceTest {

    @Mock
    // @Spy
    private MailSendClient mailSendClient;

    @Mock
    private MailSendHistoryRepository mailSendHistoryRepository;

    @InjectMocks
    private MailService mailService;

    @DisplayName("순수 Mockito 를 활용한 메일 전송 테스트.")
    @Test
    void sendMail() {
        // given
        // MailSendClient mailSendClient = Mockito.mock(MailSendClient.class);
        // MailSendHistoryRepository mailSendHistoryRepository = Mockito.mock(MailSendHistoryRepository.class);

        // MailService mailService = new MailService(mailSendClient, mailSendHistoryRepository); // 두 개의 Mock 객체를 가지고 있는 MailService

        // stubbing : 가짜 객체가 특정 호출에 대해 미리 정한 값을 반환하도록 설정한다.
//        Mockito.when(mailSendClient.sendEmail(
//            anyString(), anyString(), anyString(), anyString()
//        )).thenReturn(true);

        BDDMockito.given(mailSendClient.sendEmail(anyString(), anyString(), anyString(), anyString()))
                .willReturn(true);

        // spy
        // mailSendClient.sendEmail() 만 stubbing 하고,
        // a(), b(), c() 는 실제객체 활용
        // @Mock
        // MailSendClient mailSendClient; 하면 log("a"), log("b"), log("c") 안나옴
//        doReturn(true)
//                .when(mailSendClient)
//                .sendEmail(anyString(), anyString(), anyString(), anyString());


        // when
        boolean result = mailService.sendMail("", "", "", "");

        // then
        assertThat(result).isTrue();
        // 좀 더 명확하게 확인
        // mailSendHistoryRepository 가 몇번 호출됐는지 확인
        Mockito.verify(mailSendHistoryRepository, Mockito.times(1)).save(ArgumentMatchers.any(MailSendHistory.class));
    }

}