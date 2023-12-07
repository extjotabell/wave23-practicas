package com.mercadolibre.calculadoraedad;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;

public class Persona {
    private String nombre;
    private String apellido;
    private String signo;
    private int edad;
    private LocalDate fechaDeNacimiento;

    public Persona(String nombre, String apellido, int year, int month, int day) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = calcularFecha(year, month, day);
        this.edad = calcularEdad();
        this.signo = calcularSigno(month, day);
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

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    private int calcularEdad() {
        return Period.between(fechaDeNacimiento, LocalDate.now()).getYears();
    }

    private LocalDate calcularFecha(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    private String calcularSigno(int month, int day) {
        if (month == 1) {
            if (day >= 21) {
                return "Acuario";
            } else {
                return "Capricornio";
            }
        }
        if (month == 2) {
            if (day >= 19) {
                return "Piscis";
            } else {
                return "Acuario";
            }
        }
        if (month == 3) {
            if (day >= 20) {
                return "Aries";
            } else {
                return "Piscis";
            }
        }
        if (month == 4) {
            if (day >= 20) {
                return "Tauro";
            } else {
                return "Aries";
            }
        }
        if (month == 5) {
            if (day >= 21) {
                return "Geminis";
            } else {
                return "Tauro";
            }
        }
        if (month == 6) {
            if (day >= 20) {
                return "Cancer";
            } else {
                return "Geminis";
            }
        }
        if (month == 7) {
            if (day >= 22) {
                return "Leo";
            } else {
                return "Cancer";
            }
        }
        if (month == 8) {
            if (day >= 21) {
                return "Virgo";
            } else {
                return "Leo";
            }
        }
        if (month == 9) {
            if (day >= 22) {
                return "Libra";
            } else {
                return "Virgo";
            }
        }
        if (month == 10) {
            if (day >= 22) {
                return "Escorpion";
            } else {
                return "Libra";
            }
        }
        if (month == 11) {
            if (day >= 21) {
                return "Sagitario";
            } else {
                return "Escorpion";
            }
        }
        if (month == 12) {
            if (day >= 21) {
                return "Capricornio";
            } else {
                return "Sagitario";
            }
        }
        return "Sé lo que quieras ser";
    }

    private String calcularDiaDeSemana() {
        DayOfWeek dia = fechaDeNacimiento.getDayOfWeek();
        switch (dia) {
            case MONDAY -> { return "Lunes"; }
            case TUESDAY -> { return "Martes"; }
            case WEDNESDAY -> { return "Miércoles"; }
            case THURSDAY -> { return "Jueves"; }
            case FRIDAY -> { return "Viernes"; }
            case SATURDAY -> { return "Sábado"; }
            case SUNDAY -> { return "Domingo"; }
            default -> { return "Osvaldo"; }
        }
    }

    @Override
    public String toString() {
        return "Hola, " + nombre + " " + apellido + "!\n" +
                "Tu fecha de nacimiento es: " + fechaDeNacimiento +
                ", naciste un día: " + calcularDiaDeSemana() +
                ", actualmente tienes: " + edad +
                " años y tu signo del zodiaco es: " + signo;
    }
}
