package org.example;

public class Inscription {
    private static Integer inscriptionNumber;
    private Category category;
    private Participant participant;
    private Integer amountToPay;

    public Inscription(Category category, Participant participant, Integer amountToPay) {
        Inscription.inscriptionNumber++;
        this.category = category;
        this.participant = participant;
        this.amountToPay = amountToPay;
    }

    public void setInscriptionNumber(Integer inscriptionNumber) {
        this.inscriptionNumber = inscriptionNumber;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getAmountToPay() {
        return amountToPay;
    }

    public Participant getParticipant() {
        return participant;
    }

    @Override
    public String toString() {
        return "Inscripcion: " + "\n" +
                "Categoria: " + category + "\n" +
                "Participante: " + "\n" + participant + "\n" +
                "MontoAbonar: " + amountToPay + "\n";
    }
}
