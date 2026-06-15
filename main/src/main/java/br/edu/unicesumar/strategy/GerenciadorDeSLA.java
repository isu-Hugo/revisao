package br.edu.unicesumar.strategy;

import br.edu.unicesumar.builder.Ticket;

import java.time.LocalDateTime;

public class GerenciadorDeSLA {

    public static void exibirPrazo(Ticket ticket, CalculadoraDeSLA estrategia){
        System.out.printf("N° %d, Nivel: %s, Prazo: %s", ticket.getNumeroTicket(), estrategia.getNivelDescricao(), estrategia.calcularPrazo(ticket.getAbertura()));
    }
}
