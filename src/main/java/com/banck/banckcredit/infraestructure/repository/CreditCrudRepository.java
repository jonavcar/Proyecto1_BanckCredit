package com.banck.banckcredit.infraestructure.repository;

import com.banck.banckcredit.infraestructure.model.dao.CreditDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * Resumen...
 *
 * @author jonavcar
 */
public interface CreditCrudRepository extends ReactiveCrudRepository<CreditDao, String> {

    Flux<CreditDao> findAllByCustomer(String customer);
}
