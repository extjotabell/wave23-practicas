package org.example;

public abstract class Prototipo {

    private Integer valorInicial;

    private Integer valor;

    public Integer getValorInicial() {
        return valorInicial;
    }


    public abstract void siguienteNumero();

   public void reiniciarNumero(){
       valor = this.valorInicial;
   }

    public void setValorInicial(Integer valorInicial) {
        this.valorInicial = valorInicial;
        this.valor = valorInicial;
    }


    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
