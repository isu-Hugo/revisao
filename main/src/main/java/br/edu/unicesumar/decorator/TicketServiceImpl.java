package br.edu.unicesumar.decorator;

import br.edu.unicesumar.builder.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketServiceImpl implements ServicoDeTicket{
    private List<Ticket> tickets;

    public TicketServiceImpl() {
        this.tickets = new ArrayList<>();
    }

    @Override
    public String registrar(Ticket ticket) {
        this.tickets.add(ticket);
        return String.format("Ticket #%d registrado com sucesso", ticket.getNumeroTicket());
    }
}
