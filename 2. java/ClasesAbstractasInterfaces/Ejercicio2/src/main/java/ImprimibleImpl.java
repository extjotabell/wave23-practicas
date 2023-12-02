public class ImprimibleImpl<T> implements Imprimible<T>{

    @Override
    public void imprimir(T t) {
        System.out.println(t);
    }
}
