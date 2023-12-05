package org.example;

public class Serie2 extends Prototipo<Integer>{
    public Serie2(){
        super(2);
    }

    @Override
    public void nextValue() {
        valor = valor +2;
        System.out.println(valor);
    }

    @Override
    public void resetValue() {
        valor = 0;
        System.out.println(valor);
    }

    @Override
    public void setValue(Integer objeto) {
        valor = objeto;
        System.out.println(valor);
    }
}
