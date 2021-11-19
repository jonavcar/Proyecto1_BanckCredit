package com.banck.banckcredit.infraestructure.repository;

import com.banck.banckcredit.aplication.model.CustomerRepository;
import com.banck.banckcredit.domain.Customer;
import com.banck.banckcredit.infraestructure.model.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
@Component
public class CustomerCrudRepository implements CustomerRepository {

    @Autowired
    ICustomerCrudRepository repository;

    @Override
    public Mono<Customer> getCustomer(String dniRuc) {
        return repository.findById(dniRuc).map(this::CustomerDaoToCustomer);
    }

    public Customer CustomerDaoToCustomer(CustomerDao cd) {
        Customer customer = new Customer();
        customer.setDniRuc(cd.getDniRuc());
        customer.setCustomerType(cd.getCustomerType());
        return customer;
    }

    @Override
    public Flux<Customer> listAllCustomer() {
        return repository.findAll().map(this::CustomerDaoToCustomer);
    }

    @Override
    public Mono<Customer> create(Customer c) {
        return repository.save(CustomerToCustomerDao(c)).map(this::CustomerDaoToCustomer);
    }

    @Override
    public Mono<Customer> update(String dniRuc, Customer c) {
        c.setDniRuc(dniRuc);
        return repository.save(CustomerToCustomerDao(c)).map(this::CustomerDaoToCustomer);
    }

    @Override
    public void delete(String dniRuc) {
        repository.deleteById(dniRuc);
    }

    public CustomerDao CustomerToCustomerDao(Customer c) {
        CustomerDao customerDao = new CustomerDao();
        customerDao.setDniRuc(c.getDniRuc());
        customerDao.setCustomerType(c.getCustomerType());
        return customerDao;
    }

}
