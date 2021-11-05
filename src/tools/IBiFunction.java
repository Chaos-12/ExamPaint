package src.tools;

public interface IBiFunction<T, P> {
    T execute(P p, P q);
}
