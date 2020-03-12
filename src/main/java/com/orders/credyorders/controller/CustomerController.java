package com.orders.credyorders.controller;


import com.orders.credyorders.model.Customers;
import com.orders.credyorders.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {




    @Autowired
    private CustomerService customerSer;




    @GetMapping(value = "/order", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers(){
        List<Customers> myCustomers = customerSer.findAll();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }



    @PostMapping(value = "/new", consumes = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customers customers) {

        customerSer.save(customers);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    @PutMapping(value = "/update/{id}", consumes = {"application/json"})
    public ResponseEntity<?> updateCustomer(@PathVariable long id, @RequestBody Customers customers){
        customerSer.update(customers, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable long id){
        customerSer.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/custom/{custCode}")
    public ResponseEntity<?> findById(@PathVariable long custCode){
        customerSer.findById(custCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    }