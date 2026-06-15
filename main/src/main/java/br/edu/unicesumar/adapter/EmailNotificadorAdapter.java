package br.edu.unicesumar.adapter;

import br.edu.unicesumar.builder.Ticket;

public class EmailNotificadorAdapter implements NotificadorDeTicket{
    private SistemaEmailFornecedor sistemaEmailFornecedor;

    public EmailNotificadorAdapter() {
        this.sistemaEmailFornecedor = new SistemaEmailFornecedor();
    }

    @Override
    public void notificarAbertura(Ticket ticket, String prazoFormatado) {
        sistemaEmailFornecedor.enviarMensagem(
                ticket.getEmailSolicitante(),
                String.format("Ticket #%s aberto", ticket.getNumeroTicket()),
                String.format("[%s]: %s", ticket.getTitulo(), prazoFormatado));
    }

    @Override
    public void notificarEncerramento(int numeroTicket, String resolucao) {
        sistemaEmailFornecedor.enviarAlerta(
                "Da onde o destinatario se só recebemos o nmr do ticket?",
                String.valueOf(numeroTicket),
                resolucao
        );

    }
}
