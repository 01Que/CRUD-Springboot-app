package com.quinton;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class Controller {
    private final CustomerRepository customerRepository;

    public Controller(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //allowing user to create a row to customer database
    record newCustomerRequest(String name, String email, Integer age){

    }
    @PostMapping
    public void createCustomer(@RequestBody newCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);
        customerRepository.save(customer);
    }

    //allowing users to read our customer database
    @GetMapping
    public List<Customer> readCustomers(){
        return customerRepository.findAll();
    }

    //deleting row by id to our database
    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById(id);
    }

    //updating any row on our database

}
