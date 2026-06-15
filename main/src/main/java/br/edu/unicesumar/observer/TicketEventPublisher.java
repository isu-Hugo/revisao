package br.edu.unicesumar.observer;

import java.util.ArrayList;
import java.util.List;

public class TicketEventPublisher {
    private List<TicketAbertoObserver> ticketAbertoObservers;

    public TicketEventPublisher() {
        this.ticketAbertoObservers = new ArrayList<>();
    }

    public void registrar(TicketAbertoObserver observer){
        this.ticketAbertoObservers.add(observer);
    }

    public void publicarTicketAberto(TicketAbertoEvento evento){
        for (TicketAbertoObserver ticketAberto: ticketAbertoObservers){
            try{
                ticketAberto.aoAbrirTicket(evento);
            }catch (Exception er){
                System.out.printf("\n [ERRO] Ao usar observer [%s]", er.getMessage());
            }
        }
    }

}
