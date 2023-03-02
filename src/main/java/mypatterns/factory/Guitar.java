package mypatterns.factory;

public class Guitar implements Instrument{
    @Override
    public void play() {
        System.out.println("Guitar has been playing");
    }
}
