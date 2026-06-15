package br.edu.unicesumar.strategy;

import java.time.LocalDateTime;

public class SLABaixo implements CalculadoraDeSLA{
    @Override
    public LocalDateTime calcularPrazo(LocalDateTime abertura) {
        int tempoMaximoEspera = 72;
        return abertura.plusHours(tempoMaximoEspera);
    }

    @Override
    public String getNivelDescricao() {
        return "BAIXO, Atendimento em até 72 horas";
    }
}
