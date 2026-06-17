package br.edu.unicesumar;

import br.edu.unicesumar.adapter.EmailNotificadorAdapter;
import br.edu.unicesumar.adapter.NotificadorDeTicket;
import br.edu.unicesumar.builder.Ticket;
import br.edu.unicesumar.decorator.LogTicketDecorator;
import br.edu.unicesumar.decorator.ServicoDeTicket;
import br.edu.unicesumar.decorator.TicketServiceImpl;
import br.edu.unicesumar.decorator.ValidacaoDuplicidadeDecorator;
import br.edu.unicesumar.factory.CategoriaTicket;
import br.edu.unicesumar.factory.CategoriaTicketFactory;
import br.edu.unicesumar.factory.TipoCategoria;
import br.edu.unicesumar.observer.*;
import br.edu.unicesumar.strategy.CalculadoraDeSLA;
import br.edu.unicesumar.strategy.GerenciadorDeSLA;
import br.edu.unicesumar.strategy.NivelUrgencia;
import br.edu.unicesumar.strategy.SLAStrategyFactory;

import java.util.List;

public class Main {
    static void main() {
//        Builder
//        Ticket ticketCompleto = new Ticket
//                .Builder(1, "Ticket1", "Teste", "email@email.com")
//                .departamento("T.I.")
//                .versaoSistema("1.2.4")
//                .anexos(List.of("printf.pdf", "relatorio.pdf"))
//                .urgente(true)
//                .build();
//
//        Ticket ticketInconpleto = new Ticket
//                .Builder(2, "Ticket2", "teste", "gmail@gmail.com")
//                .build();
//
//        System.out.println("Ticket completo");
//        System.out.println(ticketCompleto.toString());
//
//        System.out.println("Ticket incompleto");
//        System.out.println(ticketInconpleto.toString());
//
//        try {
//            Ticket ticketErrado = new Ticket
//                    .Builder(3, "TicketErrado", "Teste", "email.com")
//                    .build();
//        }catch (RuntimeException er){
//            System.out.println("Ticket errado");
//            System.out.println("Um erro ao criar o ticket: " + er.getMessage());
//        }
////            --------------------------------------------------------------------------------------
//
////        FACTORY
//        CategoriaTicket ticketBug = CategoriaTicketFactory.criar(TipoCategoria.BUG);
//        CategoriaTicket ticketDuvida = CategoriaTicketFactory.criar(TipoCategoria.DUVIDA);
//        CategoriaTicket ticketAcesso = CategoriaTicketFactory.criar(TipoCategoria.ACESSO);
//
//        System.out.printf(
//                "\n\tTicket [BUG]\nNome: %s, Desc: %s, Peso: %d",
//                ticketBug.getNome(),
//                ticketBug.getDescricao(),
//                ticketBug.getPeso());
//
//        System.out.printf(
//                "\n\tTicket [Duvida]\nNome: %s, Desc: %s, Peso: %d",
//                ticketDuvida.getNome(),
//                ticketDuvida.getDescricao(),
//                ticketDuvida.getPeso());
//
//        System.out.printf(
//                "\n\tTicket [ACESSO]\nNome: %s, Desc: %s, Peso: %d",
//                ticketAcesso.getNome(),
//                ticketAcesso.getDescricao(),
//                ticketAcesso.getPeso());
////        --------------------------------------------------------------------------------------
////        Adapter
//        NotificadorDeTicket notificadorDeTicket = new EmailNotificadorAdapter();
//        notificadorDeTicket.notificarAbertura(ticketCompleto, "30-12-2005");
//        notificadorDeTicket.notificarEncerramento(ticketCompleto.getNumeroTicket(), "? ? ?");
//
////        Decorator
//        ServicoDeTicket servicoDeTicket = new LogTicketDecorator(new ValidacaoDuplicidadeDecorator(new TicketServiceImpl()));
//
//        servicoDeTicket.registrar(ticketCompleto);
//        servicoDeTicket.registrar(ticketInconpleto);
//        try{
//            servicoDeTicket.registrar(ticketInconpleto);
//        }catch (IllegalStateException er){
//            System.out.printf("\nErro ao registrar ticket: [%s]", er.getMessage());
//        }
////        Entregavel 7
//
//        CategoriaTicket categoriaTicket = CategoriaTicketFactory.criar(TipoCategoria.BUG);
//        CategoriaTicket categoriaTicket1 = CategoriaTicketFactory.criar(TipoCategoria.ACESSO);
//
//        Ticket ticket = new Ticket.Builder(1, "teste", "---", "e@e.com")
//                .anexos(List.of("pdf", "png"))
//                .build();
//        Ticket ticket1 = new Ticket.Builder(2, "bug", "---", "a@a.com").build();
//
//        CalculadoraDeSLA gerenciadorDeSLA = SLAStrategyFactory.criar(NivelUrgencia.ALTO);
//        GerenciadorDeSLA.exibirPrazo(ticket, gerenciadorDeSLA);

//

        CategoriaTicket ticketFacBug = CategoriaTicketFactory.criar(TipoCategoria.BUG);
        CategoriaTicket ticketFacDuv = CategoriaTicketFactory.criar(TipoCategoria.DUVIDA);

        Ticket ticketBuiComp = new Ticket.Builder(
                1,
                "Ticket Completo",
                "Com todos os campos",
                "hugo@gmail.com")
                .departamento("RH")
                .versaoSistema("1.2.4")
                .anexos(List.of("screenshot.jpeg", "document.pdf"))
                .urgente(true)
                .build();

        Ticket ticketBuiInc = new Ticket.Builder(
                2,
                "Ticket incompleto",
                "Apenas os campos obrigatórios",
                "hugo@gmail.com"
        ).build();

        CalculadoraDeSLA slaAlto = SLAStrategyFactory.criar(NivelUrgencia.ALTO);
        CalculadoraDeSLA slaMedio = SLAStrategyFactory.criar(NivelUrgencia.MEDIO);
        CalculadoraDeSLA slaBaixo = SLAStrategyFactory.criar(NivelUrgencia.BAIXO);
        CalculadoraDeSLA slaCritico = SLAStrategyFactory.criar(NivelUrgencia.CRITICO);
        CalculadoraDeSLA slaPlanejado = SLAStrategyFactory.criar(NivelUrgencia.PLANEJADO);

        slaAlto.calcularPrazo(ticketBuiComp.getAbertura());
        slaMedio.calcularPrazo(ticketBuiComp.getAbertura());
        slaBaixo.calcularPrazo(ticketBuiComp.getAbertura());
        slaCritico.calcularPrazo(ticketBuiComp.getAbertura());
        slaPlanejado.calcularPrazo(ticketBuiComp.getAbertura());

        EmailNotificadorAdapter emailNotificador = new EmailNotificadorAdapter();
        emailNotificador.notificarAbertura(ticketBuiComp, ticketBuiComp.getAbertura().toString());
        emailNotificador.notificarAbertura(ticketBuiInc, ticketBuiInc.getAbertura().toString());

        ServicoDeTicket impl = new TicketServiceImpl();
        ServicoDeTicket valid = new ValidacaoDuplicidadeDecorator(impl);
        ServicoDeTicket log = new LogTicketDecorator(valid);

        log.registrar(ticketBuiComp);
        log.registrar(ticketBuiInc);

        TicketAbertoObserver fila = new FilaAtendimentoObserver();
        TicketAbertoObserver metricas = new MetricasObserver();
        TicketAbertoObserver confirm = new ConfirmacaoSolicitanteObserver();

        TicketEventPublisher publisher = new TicketEventPublisher();
        publisher.registrar(fila);
        publisher.registrar(metricas);
        publisher.registrar(confirm);

        TicketFacade ticketFacade = new TicketFacade(publisher);





    }
}
