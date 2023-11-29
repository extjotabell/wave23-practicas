public class Enrollment {
    // Instance attributes
    public int dni;
    public String name;
    public String lastName;
    public int age;
    public int phone;
    public int emergencyPhone;
    public String bloodType;

    // Constructor
    public Enrollment(int dni, String name, String lastName, int age, int phone, int emergencyPhone, String bloodType) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.emergencyPhone = emergencyPhone;
        this.bloodType = bloodType;
    }

    // Methods
    public String getFullName() { return this.name + " " + this.lastName; }

    // toString
    @Override
    public String toString() { return this.getFullName(); }
}
