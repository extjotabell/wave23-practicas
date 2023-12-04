package bootcamp;

import bootcamp.Descuentos.TIPOS_DESCUENTOS;

import java.util.Map;

public interface ICalculoCosto {
    public double calcularCosto(Map<TIPOS_DESCUENTOS, Boolean> descuentosMap);
}
