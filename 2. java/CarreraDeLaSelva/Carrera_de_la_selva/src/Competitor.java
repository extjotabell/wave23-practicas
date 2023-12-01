public class Competitor {
    private int id;
    private int dni;
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String emergencyNumber;
    private String bloodType;

    public Competitor(
            int id, int dni, String firstName, String lastName, int age, String phone,
            String emergencyNumber, String bloodType) {
        this.id = id;
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.emergencyNumber = emergencyNumber;
        this.bloodType = bloodType;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Detalles del competitor: \n" +
                "ID: " + id + "\n" +
                "DNI: " + dni + "\n" +
                "Nombre: '" + firstName + '\'' + "\n" +
                "Apellido: '" + lastName + '\'' + "\n" +
                "Edad: " + age + "\n" +
                "Teléfono: '" + phone + '\'' + "\n" +
                "Teléfono de emergencia: '" + emergencyNumber + '\'' +"\n" +
                "Tipo de sangre: '" + bloodType + '\'';
    }
}
