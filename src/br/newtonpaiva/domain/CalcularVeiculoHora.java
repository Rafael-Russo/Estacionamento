package br.newtonpaiva.domain;

import java.math.BigDecimal;

public class CalcularVeiculoHora implements Calcular{

    private long hora;
    private BigDecimal valorHora;

    public CalcularVeiculoHora(long hora, BigDecimal valorHora) {
        this.hora = hora;
        this.valorHora = valorHora;
    }

    @Override
    public BigDecimal execute(){
        return valorHora.multiply(new BigDecimal(hora));
    }
}
