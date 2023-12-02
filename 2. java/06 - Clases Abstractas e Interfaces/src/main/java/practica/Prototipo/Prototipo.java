package practica.Prototipo;

public abstract class Prototipo<T extends Number>{

    protected T valorInicial;
    protected T aumento;
    abstract T sumar(T a1, T a2);

    T devuelveSiguienteValor(){
        T siguienteValor = valorInicial;
        valorInicial = sumar(valorInicial, aumento);
        return siguienteValor;
    };
    void reiniciarSerie(){
        valorInicial = null;
    };
    void crearSerieConValorInicialYAumento(T valorInicial, T aumento){
        this.valorInicial = valorInicial;
        this.aumento = aumento;
    };


}
