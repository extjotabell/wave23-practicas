public class ClaseUno extends Prototipo <Number>{

    public ClaseUno(Number inicial, Number paso) {
        super(inicial, paso);
    }

    @Override
    public Number siguiente() {
        Number resultado = valorActual;
        double valorDouble = valorActual.doubleValue() + paso.doubleValue();

        if (valorActual instanceof Integer) {
            valorActual = (Number) Integer.valueOf((int) valorDouble);
        } else if (valorActual instanceof Double) {
            valorActual = (Number) Double.valueOf(valorDouble);
        } else if (valorActual instanceof Float) {
            valorActual = (Number) Float.valueOf((float) valorDouble);
        }else if (valorActual instanceof Short) {
            valorActual = (Number) Short.valueOf((short) valorDouble);
        }else if (valorActual instanceof Byte) {
            valorActual = (Number) Byte.valueOf((byte) valorDouble);
        }
        return resultado;
    }


}
