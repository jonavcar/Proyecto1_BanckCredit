package com.banck.banckcredit.aplication;

import com.banck.banckcredit.domain.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface CreditOperations {

    public Flux<Credit> list();

    public Mono<Credit> get(String credito);

    public Mono<Credit> create(Credit c);

    public Mono<Credit> update(String credito, Credit c);

    public void delete(String credito);

}
