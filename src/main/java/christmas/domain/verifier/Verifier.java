package christmas.domain.verifier;

public interface Verifier<T> {
    public abstract void check(T input);
}
