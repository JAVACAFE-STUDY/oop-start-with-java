package net.chandol.study.oop.customer;

import net.chandol.study.oop.infra.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired CustomerRepository repository;
    @Autowired EmailService emailService;

    //회원가입을 합니다.
    public Customer signUp(CustomerRequest request){
        // 외부서비스와 연동됩니다.
        // ex 가입완료 email을 보냅니다.
        emailService.sendEmail(request.getEmail(), "가입을", "축하합니다.");

        return new Customer(request.getEmail(), request.getPassword());
    }

    public Customer getCustomer(Long id){
        return repository.getOne(id);
    }

    public Customer getCustomer(String email){
        return repository.findByEmail(email);
    }
}
