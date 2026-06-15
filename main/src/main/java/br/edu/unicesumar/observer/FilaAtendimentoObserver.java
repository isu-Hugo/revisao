package br.edu.unicesumar.observer;

import java.util.List;

public class FilaAtendimentoObserver implements TicketAbertoObserver{
    private List<String> fila;


    @Override
    public void aoAbrirTicket(TicketAbertoEvento evento) {
        String addItem = String.format(
                "#%d | {%s} | {%s} | Prazo:{%s}",
                evento.getNumeroTicket(),
                evento.getTituloTicket(),
                evento.getNivelUrgencia(),
                evento.getPrazoAtendimento()
        );
        this.fila.add(addItem);

        System.out.printf(
                "\n[FILA] Ticket #{%d} adicionado. Total na fila: %d ticket(s)",
                evento.getNumeroTicket(),
                this.fila.size()
        );
    }

    public void exibirFila(){
        for (String item: this.fila){
            System.out.println(item);
        }
    }
}
