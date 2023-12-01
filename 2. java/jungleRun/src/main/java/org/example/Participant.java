package org.example;

public class Participant {
    private static Integer participantNumber = 0;
    private Integer dni;
    private String name;
    private String surname;
    private Integer age;
    private Integer cellPhone;
    private Integer emergencyNumber;
    private String bloodType;

    public Participant(Integer dni, String name, String surname, Integer age, Integer callPhone, Integer emergencyNumber, String bloodType) {
        Participant.participantNumber++;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.cellPhone = callPhone;
        this.emergencyNumber = emergencyNumber;
        this.bloodType = bloodType;
    }

    public Integer getAge() {
        return age;
    }

    public void setParticipantNumber(Integer participantNumber) {
        this.participantNumber = participantNumber;
    }

    public Integer getDni() {
        return dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return dni.equals(that.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public String toString() {
        return "NumeroParticipante: " + participantNumber + "\n" +
                "Dni: " + dni + "\n" +
                "Nombre: " + name + "\n" +
                "Apellido: " + surname + "\n" +
                "Edad: " + age + "\n" +
                "Celular: " + cellPhone + "\n" +
                "NumeroEmergencia: " + emergencyNumber + "\n" +
                "GrupoSanguineo: " + bloodType + "\n";
    }
}
