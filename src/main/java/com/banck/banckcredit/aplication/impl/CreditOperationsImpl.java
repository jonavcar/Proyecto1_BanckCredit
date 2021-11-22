package com.banck.banckcredit.aplication.impl;

import com.banck.banckcredit.domain.Credit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.banck.banckcredit.utils.CreditType;
import com.banck.banckcredit.utils.CustomerType;
import java.util.concurrent.atomic.AtomicReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.banck.banckcredit.aplication.CreditOperations;
import com.banck.banckcredit.aplication.model.CreditRepository;

/**
 *
 * @author jonavcar
 */
@Service
@RequiredArgsConstructor
public class CreditOperationsImpl implements CreditOperations {

    Logger logger = LoggerFactory.getLogger(CreditOperationsImpl.class);
    private final CreditRepository creditRepository;

    @Override
    public Flux<Credit> list() {
        return creditRepository.list();
    }

    @Override
    public Mono<Credit> get(String credito) {
        return creditRepository.get(credito);
    }

    @Override
    public Mono<Credit> create(Credit credit) {
        AtomicReference<Mono<Credit>> atCredit = new AtomicReference<>();
        Flux<Credit> lstCredits = creditRepository.listByCustomer(credit.getCustomer());

        if (CustomerType.NATURAL_PERSON.equals(credit.getCustomerType())) {

            if (CreditType.PERSONAL_CREDIT.equals(credit.getCreditType())) {

                lstCredits.filter(act -> CreditType.PERSONAL_CREDIT.equals(act.getCreditType()))
                        .count()
                        .subscribe(count -> {
                            if (count == 0) {
                                atCredit.set(creditRepository.create(credit));
                            } else {
                                logger.warn("Usted solo puede tener un credito personal");
                            }
                        });
            } else if (CreditType.CREDIT_CARD.equals(credit.getCreditType())) {

                atCredit.set(creditRepository.create(credit));

            } else if (CreditType.BUSINESS_CREDIT.equals(credit.getCreditType())) {
                logger.warn("Usted no puede tener credito empresarial");
            }
        }

        if (CustomerType.LEGAL_PERSON.equals(credit.getCustomerType())) {

            if (CreditType.PERSONAL_CREDIT.equals(credit.getCreditType())) {
                logger.warn("Usted solo puede tener credito empresarial!!");
            } else {
                atCredit.set(creditRepository.create(credit));
            }
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            logger.error(ex.getMessage());
        }
        return atCredit.get();
    }

    @Override
    public Mono<Credit> update(String credito, Credit c
    ) {
        return creditRepository.update(credito, c);
    }

    @Override
    public void delete(String credito) {
        creditRepository.delete(credito);
    }

    @Override
    public Flux<Credit> listByCustomer(String customer
    ) {
        return creditRepository.listByCustomer(customer);
    }

}
