package mypatterns.state;

class State{
    private State implementation;
    protected State(){
    }

    public State(State implementation) {
        this.implementation = implementation;
    }

    public void change(State implementation){
        this.implementation = implementation;
    }

    public void play(){
        implementation.play();
    }
}

class Implementation1 extends State{
    @Override
    public void play() {
        System.out.println("imp1.play()");
    }
}

class Implementation2 extends State{
    @Override
    public void play() {
        System.out.println("imp2.play()");
    }
}

public class MyState {
    public static void main(String[] args) {
        State state = new State(new Implementation1());
        state.play();
        state.change(new Implementation2());
        state.play();
    }
}
