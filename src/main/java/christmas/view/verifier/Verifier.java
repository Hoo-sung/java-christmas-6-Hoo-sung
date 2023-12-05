package christmas.view.verifier;

public interface Verifier<T> {

    abstract public void validate(T input);

    static void throwIllegalArgumentError(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

    static void throwIllegalStateError(String errorMessage) {
        throw new IllegalStateException(errorMessage);
    }
}
