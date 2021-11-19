package com.banck.banckcredit.aplication.impl;

import com.banck.banckcredit.aplication.CreditOperations;
import com.banck.banckcredit.aplication.model.CreditRepository;
import com.banck.banckcredit.domain.Credit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
@Service
@RequiredArgsConstructor
public class CreditOperationsImpl implements CreditOperations {

    private final CreditRepository creditRepository;

    @Override
    public Flux<Credit> list() {
        return creditRepository.listAll();
    }

    @Override
    public Mono<Credit> get(String credito) {
        return creditRepository.get(credito);
    }

    @Override
    public Mono<Credit> create(Credit c) {
        return creditRepository.create(c);
    }

    @Override
    public Mono<Credit> update(String credito, Credit c) {
        return creditRepository.update(credito, c);
    }

    @Override
    public void delete(String credito) {
        creditRepository.delete(credito);
    }

}
