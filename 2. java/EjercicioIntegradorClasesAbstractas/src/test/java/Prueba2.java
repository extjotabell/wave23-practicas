public class Prueba2 extends Prototipo{
    private double number;
    private double result;
    @Override
    double returnNextNumber() {
        result += number;
        return result;
    }
    @Override
    double restore() {
        return this.result = 0;
    }
    @Override
    double start(double number) {
        this.result = number;
        this.number = number;
        return result;
    }
}
