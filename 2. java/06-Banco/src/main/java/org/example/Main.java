package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
    Ejecutivos ejecutivo = new Ejecutivos();
    ejecutivo.realizarDeposito();
    ejecutivo.noRealizarDeposito();
    ejecutivo.realizarTransferencia();
    ejecutivo.noRealizarTransferencia();

    Basic basico = new Basic();
    basico.pagarServicio();
    basico.noPagarServicio();
    basico.realizarConsulta();
    basico.noRealizarConsulta();
    basico.retirarEfectivo();
    basico.noRetirarEfectivo();

    Colaboradores colaborador = new Colaboradores();
    colaborador.consultarSaldo();
    colaborador.noConsultaSaldo();
    colaborador.retirarEfectivo();
    colaborador.noRetirarEfectivo();

    }
}