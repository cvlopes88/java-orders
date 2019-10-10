package com.orders.credyorders.service;

import com.orders.credyorders.model.Customers;

import java.util.List;

public interface CustomerService {

Customers save(Customers customer);

   List<Customers> findAll();

   Customers findById(long custCode);

   Customers update(Customers customers, long id);

   void delete(long id);
}
