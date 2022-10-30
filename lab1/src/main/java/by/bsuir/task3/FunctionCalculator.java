package by.bsuir.task3;

public class FunctionCalculator {
    private FunctionCalculator() {}

    public static void main(String[] args) {
        FunctionCalculator.calculate(1, 6, 10);
    }

    public static void calculate(int lowerBorder, int upperBorder, int step) {
        if (lowerBorder >= upperBorder || step <= 0) {
            return;
        }

        int x = lowerBorder;
        while (x <= upperBorder) {
            double value = Math.tan(x);
            System.out.println("x = " + x + " | F(x) = " + value);
            x += step;
        }
    }
}
