package net.chandol.study.oop.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    ResponseEntity<Customer> signUp(
            @RequestBody CustomerRequest request) {

        Customer customer = customerService.signUp(request);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/customer/{customerId}")
    ResponseEntity<Customer> getCustomer(
<<<<<<< HEAD:oop-week08/src/main/java/net/chandol/study/oop/customer/CustomerController.java
            @PathVariable(value="customerId") Customer customer) {
=======
            @PathVariable("customerId") Customer customer) {
>>>>>>> feature/week08_fianl:week08/src/main/java/net/chandol/study/oop/customer/CustomerController.java

        return ResponseEntity.ok(customer);
    }
}
