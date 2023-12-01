public class SerieDouble extends Serie<Double>{
    public SerieDouble(Double inicio, Double salto) {
        super(inicio, salto);
    }

    @Override
    public Double siguiente() {
        i ++;
        return inicio + i * salto;
    }

    @Override
    public void reiniciar() {
        System.out.println("Reiniciando");
        i = -1;
    }

    @Override
    public void setInicio(Double inicio) {
        reiniciar();
        this.inicio = inicio;
    }
}
