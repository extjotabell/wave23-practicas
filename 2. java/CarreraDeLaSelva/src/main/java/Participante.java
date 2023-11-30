public class Participante {
    private int numeroParticipante;
    private String nombre;
    private String apellido;
    private int dni;
    private String grupoSanguineo;
    private int edad;
    private int numeroEmergencia;
    private int numeroCelular;

    public Participante(int numeroParticipante, String nombre, String apellido, int dni, String grupoSanguineo, int edad, int numeroEmergencia, int numeroCelular) {
        this.numeroParticipante = numeroParticipante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.grupoSanguineo = grupoSanguineo;
        this.edad = edad;
        this.numeroEmergencia = numeroEmergencia;
        this.numeroCelular = numeroCelular;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public void setNumeroParticipante(int numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(int numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public int getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
}
