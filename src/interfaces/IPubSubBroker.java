package src.interfaces;

public interface IPubSubBroker {
    public void send(String topic, Object message);

    public void subscribe(String topic, ISub subscriber);

    public void unSubscribe(String topic, ISub subscriber);

    public void clear(String topic);
}