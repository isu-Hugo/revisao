package br.edu.unicesumar.factory;

class BugTicket implements CategoriaTicket{
    @Override
    public String getNome() {
        return "BUG";
    }

    @Override
    public String getDescricao() {
        return "Um erro no sistema";
    }

    @Override
    public int getPeso() {
        return 4;
    }
}
