package com.banck.banckcredit.spring.config;


import com.banck.banckcredit.aplication.model.CreditRepository;
import com.banck.banckcredit.infraestructure.repository.CreditCrudRepositoryImp;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Resumen...
 *
 * @author jonavcar
 */
@Configuration
public class SpringConfiguration {

    @Bean
    public CreditRepository creditRepository() {
        return new CreditCrudRepositoryImp();
    }

    /**
     * Este método realiza la configuración de Spring para la aplicación.
     */
    @Bean
    public SecureRandom secureRandom() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al obtener instancia de SecureRandom", e);
        }
    }
}
