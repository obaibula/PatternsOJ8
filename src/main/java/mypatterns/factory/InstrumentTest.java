package mypatterns.factory;

import java.util.stream.Stream;

public class InstrumentTest {
    public static void test(FactoryMethod factory){
        Stream.of("Violin", "Bassoon",
                        "Guitar", "Violin", "Guitar")
                .map(factory::create)
                .peek(Instrument::play)
                .count();
    }
}
