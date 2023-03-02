// patterns/abstractfactory/GameEnvironment.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// An example of the Abstract Factory pattern.
// {java patterns.abstractfactory.GameEnvironment}
package patterns.abstractfactory;

import java.util.function.Supplier;

interface Obstacle {
    void action();
}

interface Player {
    void interactWith(Obstacle o);
}

class Kitty implements Player {
    @Override
    public void interactWith(Obstacle ob) {
        System.out.print("Kitty has encountered a ");
        ob.action();
    }
}

class Fighter implements Player {
    @Override
    public void interactWith(Obstacle ob) {
        System.out.print("Fighter now battles a ");
        ob.action();
    }
}

class Nigger implements Player {
    @Override
    public void interactWith(Obstacle ob) {
        System.out.print("Nigger started to ");
        ob.action();
    }
}

class Puzzle implements Obstacle {
    @Override
    public void action() {
        System.out.println("Puzzle");
    }
}

class Weapon implements Obstacle {
    @Override
    public void action() {
        System.out.println("Weapon");
    }
}

class Rake implements Obstacle {
    @Override
    public void action() {
        System.out.println("Rake");
    }
}

// The Abstract Factory:
class GameElementFactory {
    Supplier<Player> player;
    Supplier<Obstacle> obstacle;
}

// Concrete factories:
class KittiesAndPuzzles
        extends GameElementFactory {
    KittiesAndPuzzles() {
        player = Kitty::new;
        obstacle = Puzzle::new;
    }
}

class Melee
        extends GameElementFactory {
    Melee() {
        player = Fighter::new;
        obstacle = Weapon::new;
    }
}

class NiggerAndRake extends GameElementFactory {
    NiggerAndRake() {
        player = Nigger::new;
        obstacle = Rake::new;
    }
}

class KittyAndRake extends GameElementFactory{
  KittyAndRake(){
    player = Kitty::new;
    obstacle = Rake::new;
  }
}

public class GameEnvironment {
    private Player p;
    private Obstacle ob;

    public GameEnvironment(GameElementFactory factory) {
        p = factory.player.get();
        ob = factory.obstacle.get();
    }

    public static void main(String[] args) {
        GameElementFactory
                kp = new KittiesAndPuzzles(),
                ml = new Melee(),
                nr = new NiggerAndRake(),
                kr = new KittyAndRake();
        GameEnvironment
                g1 = new GameEnvironment(kp),
                g2 = new GameEnvironment(ml),
                g3 = new GameEnvironment(nr),
                g4 = new GameEnvironment(kr);
        g1.play();
        g2.play();
        g3.play();
        g4.play();
    }

    public void play() {
        p.interactWith(ob);
    }
}
/* Output:
Kitty has encountered a Puzzle
Fighter now battles a Weapon
*/
