package org.example;

public class Serie3 extends Prototipo<Integer>{
    public Serie3(){
        super(0);
    }

    @Override
    public void nextValue() {
        valor = valor +3;
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
