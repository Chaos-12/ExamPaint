package src.interfaces;

public interface ISub {
    public void receive(String topic, Object message);

    public void getDispose(String topic, IBiArgFunction f);

    public void unsubscribe(String topic);
}