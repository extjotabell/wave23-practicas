package bootcamp;

public class Reserva {
    private double costo;

    public Reserva(double costo) {
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "costo=" + costo +
                '}';
    }
}
