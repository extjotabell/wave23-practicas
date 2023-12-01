public class SerieInt extends Serie<Integer> {
    public SerieInt(Integer inicio, Integer salto) {
        super(inicio, salto);
    }

    @Override
    public Integer siguiente() {
        i ++;
        return inicio + i * salto;
    }

    @Override
    public void reiniciar() {
        System.out.println("Reiniciando");
        i = -1;
    }

    @Override
    public void setInicio(Integer inicio) {
        reiniciar();
        this.inicio = inicio;
    }
}
