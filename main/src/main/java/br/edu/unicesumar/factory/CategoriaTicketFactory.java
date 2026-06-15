package br.edu.unicesumar.factory;

public class CategoriaTicketFactory {


    public static CategoriaTicket criar(TipoCategoria tipo){
        if (tipo == null) throw new RuntimeException("Categoria não pode ser null");

        return switch (tipo){
            case TipoCategoria.BUG -> new BugTicket();
            case TipoCategoria.MELHORIA -> new MelhoriaTicket();
            case TipoCategoria.DUVIDA -> new DuvidaTicket();
            case TipoCategoria.ACESSO -> new AcessoTicket();
            case TipoCategoria.INFRAESTRUTURA -> new InfraestruturaTicket();
            default -> throw new RuntimeException("Categoria inválida");
        };

    }
}
