package covid19.covid19.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@NoArgsConstructor
@Data
public class ListaDto<T> {

    ArrayList<T> listado = new ArrayList<T>();

    public ArrayList<T> getListado() {
        return listado;
    }
}
