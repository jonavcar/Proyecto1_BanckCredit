package com.banck.banckcredit.spring.config;

import com.banck.banckcredit.infraestructure.repository.CreditCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.banck.banckcredit.aplication.model.CreditRepository;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @author jonavcar
 */
@Configuration
public class SpringConfiguration {
   
    @Bean
    public CreditRepository creditRepository() {
        return new CreditCrudRepository();
    }

    @Bean
    public SecureRandom secureRandom() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al obtener instancia de SecureRandom", e);
        }
    }
}
