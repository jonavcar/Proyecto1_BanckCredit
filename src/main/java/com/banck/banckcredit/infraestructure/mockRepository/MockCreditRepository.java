package com.banck.banckcredit.infraestructure.mockRepository;

import com.banck.banckcredit.aplication.model.CreditRepository;
import com.banck.banckcredit.domain.Credit;
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
public class MockCreditRepository implements CreditRepository {

    @Override
    public Mono<Credit> get(String credito) {
        Credit c = new Credit();
        c.setCredito("34984545");
        c.setCliente("CTP");
        return Mono.just(c);
    }

    @Override
    public Flux<Credit> listAll() {
        List<Credit> lc = new ArrayList<>();
        Credit c = new Credit();
        c.setCredito("34984545");
        c.setCliente("CTP");
        lc.add(c);
        return Flux.fromIterable(lc);
    }

    @Override
    public Mono<Credit> create(Credit c) {
        return Mono.just(c);
    }

    @Override
    public Mono<Credit> update(String credito, Credit c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String dniRuc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
