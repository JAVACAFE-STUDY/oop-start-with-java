package net.chandol.study.oop.customer;

import net.chandol.study.oop.infra.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceWithMockTest {

    @MockBean
    EmailService emailService;

    @Autowired
    CustomerService customerService;

    @Test
    public void 회원가입테스트() {
        // given
        CustomerRequest request = new CustomerRequest("sejong@chandol.net", "p@ssw0rd");
        Mockito.when(emailService.sendEmail(anyString(), anyString(), anyString())).thenReturn("가짜 결과반환");

        // when
        customerService.signUp(request);

        // then
        Customer qCustomer = customerService.getCustomer("sejong@chandol.net");
        assertThat(qCustomer.getPassword(), is("p@ssw0rd"));
    }
}