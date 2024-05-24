package com.banck.banckcredit.infraestructure.repository;

import com.banck.banckcredit.aplication.model.CreditRepository;
import com.banck.banckcredit.domain.Credit;
import com.banck.banckcredit.infraestructure.model.dao.CreditDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Resumen...
 *
 * @author jonavcar
 */
@Component
public class CreditCrudRepositoryImp implements CreditRepository {

    @Autowired
    CreditCrudRepository creditRepository;

    @Override
    public Mono<Credit> get(String id) {
        return creditRepository.findById(id).map(this::creditDaoToCredit);
    }

    @Override
    public Flux<Credit> list() {
        return creditRepository.findAll().map(this::creditDaoToCredit);
    }

    @Override
    public Mono<Credit> create(Credit c) {
        return creditRepository.save(creditToCreditDao(c)).map(this::creditDaoToCredit);
    }

    @Override
    public Mono<Credit> update(String id, Credit credit) {
        credit.setCredit(id);
        return creditRepository.save(creditToCreditDao(credit)).map(this::creditDaoToCredit);
    }

    @Override
    public void delete(String id) {
        creditRepository.deleteById(id).subscribe();
    }

    @Override
    public Flux<Credit> listByCustomer(String customer) {
        return creditRepository.findAllByCustomer(customer).map(this::creditDaoToCredit);
    }

    /**
     * Convierte un objeto Credit en un objeto CreditDao.
     *
     * @param credit El objeto Credit a convertir.
     * @return El objeto CreditDao resultante.
     */
    public CreditDao creditToCreditDao(Credit credit) {
        CreditDao creditDao = new CreditDao();
        creditDao.setCredit(credit.getCredit());
        creditDao.setCustomer(credit.getCustomer());
        creditDao.setCustomerType(credit.getCustomerType());
        creditDao.setCreditType(credit.getCreditType());
        creditDao.setDateCreated(credit.getDateCreated());
        creditDao.setLimitAmount(credit.getLimitAmount());
        creditDao.setActive(credit.isActive());
        return creditDao;
    }

    /**
     * Convierte un objeto Credit en un objeto CreditDao.
     *
     * @param ad El objeto Credit a convertir.
     * @return El objeto Credit resultante.
     */
    public Credit creditDaoToCredit(CreditDao ad) {
        Credit credit = new Credit();
        credit.setCredit(ad.getCredit());
        credit.setCustomer(ad.getCustomer());
        credit.setCustomerType(ad.getCustomerType());
        credit.setCreditType(ad.getCreditType());
        credit.setDateCreated(ad.getDateCreated());
        credit.setLimitAmount(ad.getLimitAmount());
        credit.setActive(ad.isActive());
        return credit;
    }

}
