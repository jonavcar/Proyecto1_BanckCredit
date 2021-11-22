package com.banck.banckcredit.spring.config;

import com.banck.banckcredit.aplication.model.CustomerRepository;
import com.banck.banckcredit.aplication.model.CustomerTypeRepository;
import com.banck.banckcredit.infraestructure.repository.CreditCrudRepository;
import com.banck.banckcredit.infraestructure.repository.CustomerCrudRepository;
import com.banck.banckcredit.infraestructure.repository.CustomerTypeCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.banck.banckcredit.aplication.model.CreditRepository;

/**
 *
 * @author jonavcar
 */
@Configuration
public class SpringConfiguration {

    @Bean
    public CustomerRepository repository() {
        return new CustomerCrudRepository();
    }

    @Bean
    public CustomerTypeRepository repositoryCustomerType() {
        return new CustomerTypeCrudRepository();
    }
    
    @Bean
    public CreditRepository creditRepository() {
        return new CreditCrudRepository();
    }
}
