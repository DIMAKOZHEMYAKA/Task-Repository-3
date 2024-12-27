package observableElements;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import observer.IObserver;
import observer.Subject;

public class Animation extends Canvas implements IObserver {
    private double angle = 0, radius;
    private int width = 300, height = 300;

    public Animation() {
        radius = 100;
        getGraphicsContext2D().setFill(Color.GREEN);
        getGraphicsContext2D().setStroke(Color.BLUE);
        setWidth(width);
        setHeight(height);
    }

    @Override
    public void update(Subject subject) {
        angle += 10; // Увеличиваем угол
        double x = width / 2 + radius * Math.cos(Math.toRadians(angle));
        double y = height / 2 + radius * Math.sin(Math.toRadians(angle));

        getGraphicsContext2D().clearRect(0, 0, width, height);
        getGraphicsContext2D().fillOval(x - 10, y - 10, 20, 20); // Рисуем круг радиусом 10
        getGraphicsContext2D().strokeRect(0, 0, width, height);
    }
}