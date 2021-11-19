package com.banck.banckcredit.spring.config;

import com.banck.banckcredit.aplication.model.CustomerRepository;
import com.banck.banckcredit.aplication.model.CustomerTypeRepository;
import com.banck.banckcredit.infraestructure.repository.CustomerCrudRepository;
import com.banck.banckcredit.infraestructure.repository.CustomerTypeCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
