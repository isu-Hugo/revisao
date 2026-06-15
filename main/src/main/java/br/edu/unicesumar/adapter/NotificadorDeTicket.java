package br.edu.unicesumar.adapter;

import br.edu.unicesumar.builder.Ticket;

public interface NotificadorDeTicket {
    void notificarAbertura(Ticket ticket, String prazoFormatado);
    void notificarEncerramento(int numeroTicket, String resolucao);
}
