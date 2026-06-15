package br.edu.unicesumar.factory;

class AcessoTicket implements CategoriaTicket{
    @Override
    public String getNome() {
        return "ACESSO";
    }

    @Override
    public String getDescricao() {
        return "Usuário sem acesso ao sistema";
    }

    @Override
    public int getPeso() {
        return 5;
    }
}
