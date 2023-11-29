public class Participante {
    String dni;
    String nombre;
    String apellido;
    int edad;
    String celular;
    String nroEmergencia;
    String grupoSanguineo;
    Inscripcion inscripcion;
    public Participante(String dni, String nombre, String apellido, int edad,
                        String celular, String nroEmergencia, String grupoSanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.nroEmergencia = nroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNro() {
        return inscripcion.nroInscripcion;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nro=" + getNro() +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", nroEmergencia='" + nroEmergencia + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}
