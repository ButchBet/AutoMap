package module.calculator;

public class Addition implements Calculator {
    @Override
    public double operation(double a, double b) {
        return a + b;
    }
}
