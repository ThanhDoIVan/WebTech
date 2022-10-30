package by.bsuir.task9;

import java.util.List;

public class Basket {
    private List<Ball> balls;

    public Basket(List<Ball> balls) {
        this.balls = balls;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    public int countBalls(Color color) {
        return (int) balls.stream().filter(ball -> ball.getColor() == color).count();
    }

    public int getWeight() {
        return balls.stream().reduce(0, (weight, ball) -> weight + ball.getWeight(), Integer::sum);
    }
}
