package br.edu.unicesumar.factory;

class MelhoriaTicket implements CategoriaTicket{
    @Override
    public String getNome() {
        return "MELHORIA";
    }

    @Override
    public String getDescricao() {
        return "Algo no sistema que pode ser melhor";
    }

    @Override
    public int getPeso() {
        return 1;
    }
}
