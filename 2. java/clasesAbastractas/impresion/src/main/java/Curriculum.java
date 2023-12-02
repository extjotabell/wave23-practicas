public class Curriculum implements Imprimible {

    Persona persona;

    public Curriculum(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void imprimir() {
        // Lógica para imprimir el currículum
        System.out.println("Nombre: " + persona.nombre + " " + persona.apellido);
        System.out.println("Email: " + persona.email);
        System.out.println("Habilidades:");
        for (String habilidad : persona.habilidades) {
            System.out.println("- " + habilidad);
        }

    }
}
