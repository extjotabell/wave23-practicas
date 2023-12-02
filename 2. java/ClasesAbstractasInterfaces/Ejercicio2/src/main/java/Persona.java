import java.util.List;

public class Persona {
    private String name;
    private String lastname;
    private int age;
    private List<String> habilities;

    public Persona(String name, String lastname, int age, List<String> habilities) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.habilities = habilities;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age='" + age + '\'' +
                ", habilities=" + habilities +
                '}';
    }
}
