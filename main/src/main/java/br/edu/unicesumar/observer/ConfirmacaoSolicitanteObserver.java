package br.edu.unicesumar.observer;

public class ConfirmacaoSolicitanteObserver implements TicketAbertoObserver{
    @Override
    public void aoAbrirTicket(TicketAbertoEvento evento) {
        System.out.printf(
                "\n[CONFIRMAÇÃO] E-mail enviado para {%s} - Ticket #{%d} recebido, Prazo: {%s}",
                evento.getEmailSolicitante(),
                evento.getNumeroTicket(),
                evento.getPrazoAtendimento()
                );
    }
}
