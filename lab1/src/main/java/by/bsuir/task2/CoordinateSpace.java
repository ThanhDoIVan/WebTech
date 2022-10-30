package by.bsuir.task2;

import by.bsuir.model.Point;

public class CoordinateSpace {
    private CoordinateSpace() {}

    private static final double ABOVE_ZERO_X_BORDER = 4;
    private static final double BELOW_ZERO_X_BORDER = 6;
    private static final double UPPER_Y_BORDER = 5;
    private static final double LOWER_Y_BORDER = 3;

    public static boolean isPointInArea(Point point) {
        double xBorder = isAboveZero(point) ? ABOVE_ZERO_X_BORDER : BELOW_ZERO_X_BORDER;
        double yBorder = isAboveZero(point) ? UPPER_Y_BORDER : LOWER_Y_BORDER;

        return (Math.abs(point.getX()) <= xBorder) && (Math.abs(point.getY()) <= yBorder);
    }

    private static boolean isAboveZero(Point point) {
        return point.getY() > 0;
    }
}
