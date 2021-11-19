package com.banck.banckcredit.infraestructure.mockRepository;

import com.banck.banckcredit.aplication.model.CustomerRepository;
import com.banck.banckcredit.domain.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
@Component
public class MockCustomerRepository implements CustomerRepository {

    @Override
    public Mono<Customer> getCustomer(String dniRuc) {
        Customer c = new Customer();
        c.setDniRuc("34984545");
        c.setCustomerType("CTP");
        return Mono.just(c);
    }

    @Override
    public Flux<Customer> listAllCustomer() {
        List<Customer> lc = new ArrayList<>();
        Customer c = new Customer();
        c.setDniRuc("34984545");
        c.setCustomerType("CTP");
        lc.add(c);
        return Flux.fromIterable(lc);
    }

    @Override
    public Mono<Customer> create(Customer c) {
        return Mono.just(c);
    }

    @Override
    public Mono<Customer> update(String dniRuc, Customer c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String dniRuc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
