package com.banck.banckcredit.infraestructure.repository;

import com.banck.banckcredit.infraestructure.model.dao.CustomerTypeDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 *
 * @author jonavcar
 */
public interface ICustomerTypeCrudRepository extends ReactiveCrudRepository<CustomerTypeDao, String> {

}
