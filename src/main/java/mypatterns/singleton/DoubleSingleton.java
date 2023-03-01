package mypatterns.singleton;

public final class DoubleSingleton implements Resource<Double>{
    private static DoubleSingleton instance =  new DoubleSingleton();
    private Double value;

    private DoubleSingleton() {
    }

    public static DoubleSingleton getInstance(){
        return instance;
    }

    @Override
    public synchronized Double get() {
        return value;
    }

    @Override
    public synchronized void set(Double value) {
        this.value = value;
    }
}
