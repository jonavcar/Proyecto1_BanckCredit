package com.banck.banckcredit.infraestructure.repository;

import com.banck.banckcredit.aplication.model.CreditRepository;
import com.banck.banckcredit.domain.Credit;
import com.banck.banckcredit.infraestructure.model.dao.CreditDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
@Component
public class CreditCrudRepository implements CreditRepository {

    @Autowired
    ICreditCrudRepository creditRepository;

    @Override
    public Mono<Credit> get(String credito) {
        return creditRepository.findById(credito).map(this::CreditDaoToCredit);
    }

    public Credit CreditDaoToCredit(CreditDao cd) {
        Credit credit = new Credit();
        credit.setCredito(cd.getCredito());
        credit.setCliente(cd.getCliente());
        credit.setTipoCliente(cd.getTipoCliente());
        credit.setTipoCredito(cd.getTipoCredito());
        credit.setMontoLimite(cd.getMontoLimite());
        credit.setFecha(cd.getFecha());
        return credit;
    }

    @Override
    public Flux<Credit> listAll() {
        return creditRepository.findAll().map(this::CreditDaoToCredit);
    }

    @Override
    public Mono<Credit> create(Credit c) {
        return creditRepository.save(CreditToCreditDao(c)).map(this::CreditDaoToCredit);
    }

    @Override
    public Mono<Credit> update(String credito, Credit c) {
        c.setCredito(credito);
        return creditRepository.save(CreditToCreditDao(c)).map(this::CreditDaoToCredit);
    }

    @Override
    public void delete(String credito) {
        creditRepository.deleteById(credito);
    }

    public CreditDao CreditToCreditDao(Credit c) {
        CreditDao creditDao = new CreditDao();
        creditDao.setCredito(c.getCredito());
        creditDao.setCliente(c.getCliente());
        creditDao.setTipoCliente(c.getTipoCliente());
        creditDao.setTipoCredito(c.getTipoCredito());
        creditDao.setMontoLimite(c.getMontoLimite());
        creditDao.setFecha(c.getFecha());
        return creditDao;
    }

}
