package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimeServer implements Subject {

    private Timer timer;
    private TimerTask task;
    private long delay = 1000, period = 1000;
    private int timeState;
    private List<IObserver> observer = new ArrayList<>();

    private void tick() {
        timeState++;
        notifyAllObserver();
    }

    public int getState() {
        return timeState;
    }

    public void setState(int time) {
        timeState = time;
    }

    public void stop() {
        timeState = 0;
        notifyAllObserver();
        timer.cancel();
        timer = null;
    }

    public void start() {
        if (timer == null) {
            this.timer = new Timer();
            task = new TimerTask() {
                public void run() {
                    tick();
                }
            };
            timer.schedule(task, delay, period);
        } else {
            System.out.println("Таймер уже запущен");
        }
    }

    public void attach(IObserver observer) {
        this.observer.add(observer);
    }

    public void detach(IObserver observer) {
        this.observer.remove(observer);
    }

    public void notifyAllObserver() {

        for (IObserver observer : observer) {
            observer.update(this);
        }

    }
}