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
            @PathVariable(value="customerId") Customer customer) {

        return ResponseEntity.ok(customer);
    }
}
