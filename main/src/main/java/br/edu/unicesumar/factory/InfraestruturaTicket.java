package br.edu.unicesumar.factory;

class InfraestruturaTicket implements CategoriaTicket{
    @Override
    public String getNome() {
        return "INFRAESTRUTURA";
    }

    @Override
    public String getDescricao() {
        return "Problemas com a infraestrutura do sistema";
    }

    @Override
    public int getPeso() {
        return 3;
    }
}
