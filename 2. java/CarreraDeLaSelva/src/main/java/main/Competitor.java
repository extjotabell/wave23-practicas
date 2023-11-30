package main;

public class Competitor {
    private long numberCompetitor;
    private long dni;
    private String name;
    private String lastname;
    private int age;
    private String phoneNumber;
    private String emergencyNumber;
    private String bloodType;

    public Competitor(long numberCompetitor, long dni, String name, String lastname, int age, String phoneNumber, String emergencyNumber, String bloodType) {
        this.numberCompetitor = numberCompetitor;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emergencyNumber = emergencyNumber;
        this.bloodType = bloodType;
    }

    public void showInfo(){
        System.out.println("Competitor number: " + this.numberCompetitor);
        System.out.println("Dni: " + this.dni);
        System.out.println("Name: " + this.name);
        System.out.println("Lastname: " + this.lastname);
        System.out.println("Age: " + this.age);
        System.out.println("Phone number: " + this.phoneNumber);
        System.out.println("Emergency number: " + this.emergencyNumber);
        System.out.println("Blood type: " + this.bloodType);
    }

    public long getNumberCompetitor() {
        return numberCompetitor;
    }

    public void setNumberCompetitor(long numberCompetitor) {
        this.numberCompetitor = numberCompetitor;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
