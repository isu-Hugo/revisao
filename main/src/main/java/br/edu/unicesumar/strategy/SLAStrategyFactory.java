package br.edu.unicesumar.strategy;

public class SLAStrategyFactory {

    public static CalculadoraDeSLA criar(NivelUrgencia nivel){
        if (nivel == null) throw new RuntimeException("Nivel de urgência inválido");

        return switch (nivel){
            case NivelUrgencia.CRITICO -> new SLACritico();
            case NivelUrgencia.ALTO -> new SLAAlto();
            case NivelUrgencia.MEDIO -> new SLAMedio();
            case NivelUrgencia.BAIXO -> new SLABaixo();
            case NivelUrgencia.PLANEJADO -> new SLAPlanejado();
            default -> throw new RuntimeException("Nivel de urgência inválido");
        };
    }
}
