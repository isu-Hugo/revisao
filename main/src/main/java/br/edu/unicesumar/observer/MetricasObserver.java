package br.edu.unicesumar.observer;

import java.util.HashMap;
import java.util.Map;

public class MetricasObserver implements TicketAbertoObserver{
    private Map<String, Integer> ticketsPorCategoria;

    public MetricasObserver() {
        this.ticketsPorCategoria = new HashMap<>();
    }

    @Override
    public void aoAbrirTicket(TicketAbertoEvento evento) {
        String categoria = evento.getNomeCategoria();
        if (this.ticketsPorCategoria.containsKey(categoria)){
            Integer item = this.ticketsPorCategoria.get(categoria);
            this.ticketsPorCategoria.put(categoria, item + 1);
        }else {
            this.ticketsPorCategoria.put(categoria, 1);
        }

        System.out.printf(
                "[MÉTRICAS] Categoria '{%s}': %d ticket(s) aberto(s) no total",
                categoria,
                this.ticketsPorCategoria.get(categoria)
                );
    }
}
