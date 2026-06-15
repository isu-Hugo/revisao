package br.edu.unicesumar.factory;

class DuvidaTicket implements CategoriaTicket{
    @Override
    public String getNome() {
        return "DUVIDA";
    }

    @Override
    public String getDescricao() {
        return "Uma duvida sobre o sistema";
    }

    @Override
    public int getPeso() {
        return 2;
    }
}
