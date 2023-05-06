package br.newtonpaiva.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Ticket {
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Veiculo veiculo;

    public Ticket() {
        this(null, null);
    }

    public Ticket(LocalDateTime dataInicio, Veiculo veiculo) {
        this.dataInicio = dataInicio;
        this.veiculo = veiculo;
    }

    public BigDecimal fecharTicket(Calcular calcular) {
        this.setDataFim(LocalDateTime.now());

        long horas = ChronoUnit.HOURS.between(dataInicio, dataFim);
        long dias = ChronoUnit.DAYS.between(dataInicio, dataFim);
        long meses = ChronoUnit.MONTHS.between(dataInicio, dataFim);

        if (veiculo instanceof Veiculo){
            if (horas < 12) {
                return new BigDecimal(horas * 10);
            } else if (dias < 15) {
                if (dias == 0)
                    dias = 1;
                return new BigDecimal(dias * 40);
            } else {
                if (meses == 0)
                    meses = 1;
                return new BigDecimal(meses * 200);
            }
        }
        return calcular.execute();
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }
}