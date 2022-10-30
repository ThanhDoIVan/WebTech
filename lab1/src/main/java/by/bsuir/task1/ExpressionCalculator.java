package by.bsuir.task1;

public class ExpressionCalculator {
    private ExpressionCalculator() {}

    public static double calc(double x, double y) {
        double numerator = calcNumerator(x, y);
        double denominator = calcDenominator(x, y);

        return numerator / denominator + x;
    }

    private static double calcNumerator(double x, double y) {
        return 1 + Math.pow(Math.sin(x + y), 2);
    }

    private static double calcDenominator(double x, double y) {
        return 2 + Math.abs(x - (2 * x) / (1 + Math.pow(x, 2) * Math.pow(y, 2)));
    }
}
