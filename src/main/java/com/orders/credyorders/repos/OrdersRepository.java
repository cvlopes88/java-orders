package com.orders.credyorders.repos;


import com.orders.credyorders.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {


}
