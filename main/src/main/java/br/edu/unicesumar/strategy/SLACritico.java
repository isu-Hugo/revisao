package br.edu.unicesumar.strategy;

import java.time.LocalDateTime;

public class SLACritico implements CalculadoraDeSLA{
    @Override
    public LocalDateTime calcularPrazo(LocalDateTime abertura) {
        int tempoMaximoEspera = 4;
        return abertura.plusHours(tempoMaximoEspera);
    }

    @Override
    public String getNivelDescricao() {
        return "CRITICO, Atendimento em até 4 horas";
    }
}
