package com.banck.banckcredit.infraestructure.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jonavcar
 */
@Data
@Document("credit")
public class CreditDao {

    @Id
    public String credito;
    public String cliente;
    public String tipoCliente;
    public String tipoCredito;
    public int montoLimite;
    public String fecha;
}
