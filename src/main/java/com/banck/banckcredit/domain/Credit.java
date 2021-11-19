package com.banck.banckcredit.domain;

import lombok.Data;

/**
 *
 * @author jonavcar
 */
@Data
public class Credit {

    public String credito;
    public String cliente;
    public String tipoCliente;
    public String tipoCredito;
    public int montoLimite;
    public String fecha;
}
