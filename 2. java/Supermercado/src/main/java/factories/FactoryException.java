package factories;

import Exceptions.ClientNotFoundException;
import Exceptions.ElementNotFoundException;
import Exceptions.FacturaNotFoundException;

public class FactoryException {

    public static ElementNotFoundException createException(TipoExcepcion tipoExcepcion, String id){
        switch (tipoExcepcion){
            case CLIENTE_EXCEPCION -> {return new ClientNotFoundException(id);}
            case FACTURA_EXCEPCION -> {return new FacturaNotFoundException(id);}
            default -> {return new ElementNotFoundException("Ocurrio un error");}
        }
    }
}
