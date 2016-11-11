package net.chandol.study.oop.customer;

import net.chandol.study.oop.infra.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CustomerIntegrationTest {

    @MockBean
    EmailService emailService;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void 회원가입_플로우_확인(){
        ResponseEntity<Customer> customerEntity = restTemplate.postForEntity("/customer", new CustomerRequest("email", "password"), Customer.class);
        assertTrue(customerEntity.getStatusCode().is2xxSuccessful());
        Customer customer = customerEntity.getBody();
        assertThat(customer.getEmail(), is("email"));


        ResponseEntity<Customer> readCustomerEntity = restTemplate.getForEntity("/customer/" + customer.getId(), Customer.class);
        assertTrue(readCustomerEntity.getStatusCode().is2xxSuccessful());
        Customer readCustomer = readCustomerEntity.getBody();
        assertThat(readCustomer.getEmail(), is("email"));
    }
}
