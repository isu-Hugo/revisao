package br.edu.unicesumar.decorator;

import br.edu.unicesumar.builder.Ticket;

import java.util.HashSet;
import java.util.Set;

public class ValidacaoDuplicidadeDecorator implements ServicoDeTicket{
    private final ServicoDeTicket servicoDeTicket;
    private Set<Integer> ticketsRegistrados;

    public ValidacaoDuplicidadeDecorator(ServicoDeTicket servicoDeTicket) {
        this.servicoDeTicket = servicoDeTicket;
        this.ticketsRegistrados = new HashSet<>();
    }

    @Override
    public String registrar(Ticket ticket) {

        if (ticketsRegistrados.contains(ticket.getNumeroTicket()))
            throw new IllegalStateException(String.format(
                    "Ticket #{%d} já existe no sistema", ticket.getNumeroTicket()));

        this.ticketsRegistrados.add(ticket.getNumeroTicket());

        String message = this.servicoDeTicket.registrar(ticket);
        return message;
    }
}
