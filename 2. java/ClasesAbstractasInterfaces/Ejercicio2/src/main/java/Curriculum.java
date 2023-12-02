import java.util.List;

public class Curriculum {
    List<Persona> persona;

    public Curriculum(List<Persona> persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona +
                '}';
    }
}
