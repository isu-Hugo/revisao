package br.edu.unicesumar.observer;

import br.edu.unicesumar.builder.Ticket;
import br.edu.unicesumar.factory.CategoriaTicket;
import br.edu.unicesumar.factory.CategoriaTicketFactory;
import br.edu.unicesumar.factory.TipoCategoria;
import br.edu.unicesumar.strategy.CalculadoraDeSLA;
import br.edu.unicesumar.strategy.NivelUrgencia;
import br.edu.unicesumar.strategy.SLAStrategyFactory;

public class TicketFacade {

    private TicketEventPublisher publisher;

    public TicketFacade(TicketEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void abrirTicket(Ticket ticket, NivelUrgencia nivel, CategoriaTicket categoria){

        CategoriaTicket categoriaTicket = CategoriaTicketFactory.criar(TipoCategoria.valueOf(categoria.getNome()));
        CalculadoraDeSLA estrategia = SLAStrategyFactory.criar(nivel);
        TicketAbertoEvento ticketAbertoEvento = new TicketAbertoEvento(
                ticket.getNumeroTicket(),
                ticket.getEmailSolicitante(),
                ticket.getTitulo(),
                categoria.getNome(),
                nivel,
                estrategia.calcularPrazo(ticket.getAbertura())
        );

        publisher.publicarTicketAberto(ticketAbertoEvento);

    }
}
