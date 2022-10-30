package by.bsuir.task9;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket(List.of(
                new Ball(10, Color.BLUE),
                new Ball(12, Color.BLUE),
                new Ball(9, Color.RED),
                new Ball(10, Color.RED),
                new Ball(11, Color.RED)
        ));

        System.out.println("Quantity of red balls - " + basket.countBalls(Color.RED));
        System.out.println("Summary weight of basket - " + basket.getWeight());
    }
}
