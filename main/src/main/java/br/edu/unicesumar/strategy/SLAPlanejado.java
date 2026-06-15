package br.edu.unicesumar.strategy;

import java.time.LocalDateTime;

public class SLAPlanejado implements CalculadoraDeSLA{
    @Override
    public LocalDateTime calcularPrazo(LocalDateTime abertura) {
        int tempoMaximoEspera = 168;
        return abertura.plusHours(tempoMaximoEspera);
    }

    @Override
    public String getNivelDescricao() {
        return "PLANEJADO, Atendimento em até 168 horas";
    }
}
