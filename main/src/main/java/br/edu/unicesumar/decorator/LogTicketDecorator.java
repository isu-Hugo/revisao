package br.edu.unicesumar.decorator;

import br.edu.unicesumar.builder.Ticket;

import java.time.LocalDateTime;

public class LogTicketDecorator implements ServicoDeTicket{
    private final ServicoDeTicket servicoDeTicket;

    public LogTicketDecorator(ServicoDeTicket servicoDeTicket) {
        this.servicoDeTicket = servicoDeTicket;
    }

    @Override
    public String registrar(Ticket ticket) {

        System.out.printf(
                "\n[LOG]{%s} - Registrando ticket #{%d} - Solicitante: {%s}\n",
                LocalDateTime.now().toString(),
                ticket.getNumeroTicket(),
                ticket.getEmailSolicitante());

        String message = this.servicoDeTicket.registrar(ticket);

        System.out.printf(
                "[LOG]{%s} - Ticket #{%d} processando",
                LocalDateTime.now().toString(),
                ticket.getNumeroTicket());

        return message;
    }
}
