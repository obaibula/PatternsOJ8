package mypatterns.singleton;

public interface Resource<T> {
    T get();
    void set(T value);
}
