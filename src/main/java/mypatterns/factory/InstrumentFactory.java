package mypatterns.factory;

import patterns.shapes.FactoryTest;

public class InstrumentFactory implements FactoryMethod {
    @Override
    public Instrument create(String name) {
        switch (name) {
            case "Violin":
                return new Violin();
            case "Bassoon":
                return new Bassoon();
            case "Guitar":
                return new Guitar();
            default:
                throw new RuntimeException("Wrong Instrument");
        }
    }

    public static void main(String[] args) {
        InstrumentTest.test(new InstrumentFactory());
    }
}
