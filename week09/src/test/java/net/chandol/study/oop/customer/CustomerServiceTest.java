package net.chandol.study.oop.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void 회원가입테스트() {
        // given
        CustomerRequest request = new CustomerRequest("sejong@chandol.net", "p@ssw0rd");

        // when
        customerService.signUp(request);

        // then
        Customer qCustomer = customerService.getCustomer("sejong@chandol.net");
        assertThat(qCustomer.getPassword(), is("p@ssw0rd"));
    }
}