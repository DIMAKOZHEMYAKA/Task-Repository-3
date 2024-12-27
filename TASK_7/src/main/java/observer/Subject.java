package observer;

public interface Subject {

    public void notifyAllObserver();//уведомить

    public void attach(IObserver obs);//добавить слушателя

    public void detach(IObserver obs);//удалить слушателя

    public int getState();
}