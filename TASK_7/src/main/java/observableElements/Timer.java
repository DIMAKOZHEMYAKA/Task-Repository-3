package observableElements;

import javafx.application.Platform;
import javafx.scene.control.Label;
import observer.IObserver;
import observer.Subject;
import observer.TimeServer;

public class Timer extends Label implements IObserver {
    private int localTime = 0;

    @Override
    public void update(Subject subject) {
        if (subject instanceof TimeServer) {
            localTime = subject.getState();
            System.out.println("Времени прошло: " + localTime + " секунд.");
            Platform.runLater(() -> setText("Времени прошло: " + localTime + " секунд."));
        }
    }
}