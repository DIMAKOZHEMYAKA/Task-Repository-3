package observer;

public interface IObserver {

    Subject subject = null;

    public abstract void update(Subject subject);

}