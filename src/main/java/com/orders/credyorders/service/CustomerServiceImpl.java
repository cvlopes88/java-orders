package com.orders.credyorders.service;

import com.orders.credyorders.model.Customers;
import com.orders.credyorders.model.Orders;
import com.orders.credyorders.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerSer")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomersRepository custRepo;

//
//


    @Override
    public List<Customers> findAll() {
        List<Customers> cusList = new ArrayList<>();
        custRepo.findAll().iterator().forEachRemaining(cusList::add);
        return cusList;
    }

    @Override
    public Customers findById(long custCode) {
        return custRepo.findById(custCode).orElseThrow(() -> new EntityNotFoundException( custCode +"dont exist"));
    }

    @Override
    public Customers update(Customers customers, long id) {

        return custRepo.save(customers);
    }

    @Override
    public void delete(long id) {
        custRepo.deleteById(id);

    }

    @Transactional
    @Override
    public Customers save(Customers customer) {
        Customers newCustomer = new Customers();
        newCustomer.setCustName(customer.getCustName());
        newCustomer.setCustCity(customer.getCustCity());
        newCustomer.setWorkingArea(customer.getWorkingArea());
        newCustomer.setCustCountry(customer.getCustCountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningAmt(customer.getOpeningAmt());
        newCustomer.setReceiveAmt(customer.getReceiveAmt());
        newCustomer.setPaymentAmt(customer.getPaymentAmt());
        newCustomer.setOutstandingAmt(customer.getOutstandingAmt());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setAgent(customer.getAgent());


        for (Orders o : customer.getOrders()) {

            newCustomer.getOrders().add(new Orders(o.getOrdAmount(), o.getAdvanceAmount(), o.getCustomer(), o.getOrderDescription()));
        }
        return custRepo.save(newCustomer);
    }



}
