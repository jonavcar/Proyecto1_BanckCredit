package com.banck.banckcredit.infraestructure.rest;

import com.banck.banckcredit.aplication.CreditOperations;
import com.banck.banckcredit.aplication.CustomerOperations;
import com.banck.banckcredit.domain.Credit;
import com.banck.banckcredit.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
@RestController
@RequestMapping("/credit")
@RequiredArgsConstructor
public class CreditController {

    private final CreditOperations operations;

    @GetMapping
    public Flux<Credit> listAll() {
        return operations.list();
    }

    @GetMapping("/{id}")
    public Mono<Credit> get(@PathVariable("id") String credito) {
        return operations.get(credito);
    }

    @PostMapping
    public Mono<Credit> create(@RequestBody Credit c) {
        return operations.create(c);
    }

    @PutMapping("/{id}")
    public Mono<Credit> update(@PathVariable("id") String credito, @RequestBody Credit c) {
        return operations.update(credito, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String credito) {
        operations.delete(credito);
    }
}
