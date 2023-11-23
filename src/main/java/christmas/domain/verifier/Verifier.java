package christmas.domain.verifier;

public interface Verifier<T> {
    public  void check(T input);

    static void throwError(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
