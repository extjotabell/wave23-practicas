package org.example;

public class EscenaryThree extends Prototype<Double> {
    private Double number;
    private Double sum;

    public EscenaryThree() {
        this.sum = 0.0;
    }

    public EscenaryThree(Double number) {
        this.sum = 0.0;
        this.number = number;
    }

    @Override
    Double getNumberNextProgressive() {
        return this.sum += this.number;
    }

    @Override
    void restartSerie() {
        this.sum = 0.0;
    }

    @Override
    void setNumberNextProgresive(Double number) {
        this.number = number;
    }
}
