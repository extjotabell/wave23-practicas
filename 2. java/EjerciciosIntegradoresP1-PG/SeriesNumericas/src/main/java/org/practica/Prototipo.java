package org.practica;

public abstract class Prototipo <T extends Number>{
    private T initialValue;
    private T value;

    public Prototipo (T initialValue) {
        this.initialValue = initialValue;
        this.value = initialValue;
    }

    public abstract T getNextValue();

    public void restart(){
        this.value = this.initialValue;
    }

    public T getInitialValue(){
        return initialValue;
    }
    public void setInitialValue(T newInitialValue){
        this.initialValue = newInitialValue;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T newValue){
        this.value = newValue;
    }
}
