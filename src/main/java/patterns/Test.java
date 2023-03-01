package patterns;

public class Test {
    public static void main(String[] args) {
        Single<Integer> integerSingle = new Single<>(3);
        Single<Integer> integerSingle1 = brakeSingleton(14);
    }
    public static <T>Single<T> brakeSingleton(T val){
        new Single<T>(null);
        return new Single<>(val);
    }
}
