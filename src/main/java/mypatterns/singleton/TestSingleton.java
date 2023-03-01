package mypatterns.singleton;

public class TestSingleton {
    public static void main(String[] args) {
        Resource<Double> doubleSingleton = DoubleSingleton.getInstance();
        doubleSingleton.set(0.44d);

        Resource<Double> doubleResource = DoubleSingleton.getInstance();

        System.out.println(doubleResource.get());
    }
}
