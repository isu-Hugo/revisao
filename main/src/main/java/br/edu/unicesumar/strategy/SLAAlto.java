package br.edu.unicesumar.strategy;

import java.time.LocalDateTime;

public class SLAAlto implements CalculadoraDeSLA{
    @Override
    public LocalDateTime calcularPrazo(LocalDateTime abertura) {
        int tempoMaximoEspera = 8;
        return abertura.plusHours(tempoMaximoEspera);
    }

    @Override
    public String getNivelDescricao() {
        return "ALTO, Atendimento em até 8 horas";
    }
}
