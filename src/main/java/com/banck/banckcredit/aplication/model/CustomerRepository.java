package com.banck.banckcredit.aplication.model;

import com.banck.banckcredit.domain.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface CustomerRepository {

    public Mono<Customer> getCustomer(String dniRuc);

    public Flux<Customer> listAllCustomer();

    public Mono<Customer> create(Customer c);

    public Mono<Customer> update(String dniRuc, Customer c);

    public void delete(String dniRuc);
}
