package src.interfaces;

public interface IPubSubBroker<T, M> {
    public void emit(M message);

    public IFunction<T> on(ISub subscriber);
}