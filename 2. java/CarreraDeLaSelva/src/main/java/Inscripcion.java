public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double montoInscripcion;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) throws Exception {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.montoInscripcion = calcularMonto();
    }

    public double calcularMonto() throws Exception {
        if(categoria.getId() == 1){
            if(participante.getEdad() < 18){
                return 1300;
            }else{
                return 1500;
            }
        } else if (categoria.getId() == 2){
            if(participante.getEdad() < 18){
                return 2000;
            }else{
                return 2300;
            }
        } else {
            if(participante.getEdad() < 18){
                throw new Exception("Error");
            }else{
                return 2800;
            }
        }
    }
    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getMontoInscripcion() {
        return montoInscripcion;
    }

    public void setMontoInscripcion(double montoInscripcion) {
        this.montoInscripcion = montoInscripcion;
    }
}
