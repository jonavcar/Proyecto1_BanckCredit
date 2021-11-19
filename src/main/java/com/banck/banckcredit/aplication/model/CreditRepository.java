package com.banck.banckcredit.aplication.model;

import com.banck.banckcredit.domain.Credit;
import com.banck.banckcredit.domain.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface CreditRepository {

    public Mono<Credit> get(String credito);

    public Flux<Credit> listAll();

    public Mono<Credit> create(Credit c);

    public Mono<Credit> update(String credito, Credit c);

    public void delete(String credito);
}
