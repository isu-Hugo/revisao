package br.edu.unicesumar.strategy;

import java.time.LocalDateTime;

public class SLAMedio implements CalculadoraDeSLA{
    @Override
    public LocalDateTime calcularPrazo(LocalDateTime abertura) {
        int tempoMaximoEspera = 24;
        return abertura.plusHours(tempoMaximoEspera);
    }

    @Override
    public String getNivelDescricao() {
        return "MEDIO, Atendimento em até 24 horas";
    }
}
