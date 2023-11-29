public class Inscripcion {
    static int countNroParticipante = 0;
    Categoria categoria;
    Participante participante;
    int nroInscripcion;
    double monto;

    public Inscripcion(Categoria categoria, Participante participante) {
        this.categoria = categoria;
        this.participante = participante;
        this.nroInscripcion = countNroParticipante++;
        if(participante.edad>=18){
            this.monto = categoria.costoMayores;
        }else{
            this.monto= categoria.costoMenores;
        }
        System.out.println("El monto a abonar es de " + monto);
    }
}
