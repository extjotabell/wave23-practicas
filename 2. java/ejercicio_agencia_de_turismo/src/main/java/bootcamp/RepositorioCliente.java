package bootcamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bootcamp.Descuentos.TIPOS_DESCUENTOS;

public class RepositorioCliente{
    private Cliente cliente;
    private List<Localizador> localizadores;

    private Map<Descuentos.TIPOS_DESCUENTOS, Boolean> descuentosMap;

    public RepositorioCliente(Cliente cliente) {
        this.cliente = cliente;
        this.localizadores = new ArrayList<>();
        this.descuentosMap = new HashMap<>();
        for(var descuento : Descuentos.TIPOS_DESCUENTOS.values()) {
            descuentosMap.put(descuento, false);
        }
    }

    public double calcularCosto() {
        return localizadores.stream().mapToDouble(Localizador::getTotal).sum();
    }

    public void realizarCompraLocalizador(Localizador localizador) {
        //Mayor o igual a uno porque aún no se está contando el localizador actual
        if (!descuentosMap.get(TIPOS_DESCUENTOS.FUTURAS_COMPRAS) && localizadores.size() >= 2) {
            descuentosMap.put(TIPOS_DESCUENTOS.FUTURAS_COMPRAS, true);
        }
        descuentosMap.put(TIPOS_DESCUENTOS.PAQUETE_COMPLETO, localizador.paqueteCompleto());
        descuentosMap.put(TIPOS_DESCUENTOS.DOS_RESERVAS_O_DOS_BOLETOS, localizador.dosBoletosODosReservas());

        localizador.calcularCosto(descuentosMap);

        System.out.println(localizador);

    }
}
