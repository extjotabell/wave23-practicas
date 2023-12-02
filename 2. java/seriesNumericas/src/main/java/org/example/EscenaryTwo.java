package org.example;

public class EscenaryTwo extends Prototype<Integer> {
    private Integer number;
    private Integer sum;

    public EscenaryTwo() {
        this.sum = 0;
    }

    public EscenaryTwo(Integer number) {
        this.sum = 0;
        this.number = number;
    }

    @Override
    Integer getNumberNextProgressive() {
        return this.sum += this.number;
    }

    @Override
    void restartSerie() {
        this.sum = 0;
    }

    @Override
    void setNumberNextProgresive(Integer number) {
        this.number = number;
    }
}
