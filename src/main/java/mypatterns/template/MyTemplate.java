package mypatterns.template;


import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

abstract class Template {
    public void template() {
        Arrays.stream(doInts())
                .max()
                .ifPresent(System.out::println);

        Arrays.stream(doDoubles())
                .max()
                .ifPresent(System.out::println);
    }

    abstract int[] doInts();

    abstract double[] doDoubles();
}

class Factorial extends Template {
    @Override
    int[] doInts() {
        int[] factorials = new int[5];
        int multiplicate = 1;
        for (int i = 1; i <= 5; i++) {
            multiplicate = multiplicate * i;
            factorials[i - 1] = multiplicate;
        }
        return factorials;
    }

    @Override
    double[] doDoubles() {
        double[] factorials = new double[5];
        double multiplicate = 1;
        for (int i = 1; i <= 5; i++) {
            multiplicate = multiplicate * i;
            factorials[i - 1] = multiplicate;
        }
        return factorials;
    }
}

class Linear extends Template {

    @Override
    int[] doInts() {
        return IntStream.rangeClosed(0, 10)
                .toArray();
    }

    @Override
    double[] doDoubles() {
        return DoubleStream.iterate(0.33, d -> d - 0.71)
                .limit(10)
                .toArray();
    }
}

class SomethingElse extends Template {
    @Override
    int[] doInts() {
        return IntStream.iterate(0, i -> i % 3 == 0 ? i - 10 : i + 11)
                .limit(25)
                .toArray();
    }

    @Override
    double[] doDoubles() {
        return DoubleStream.iterate(1, d -> d > 0.001 ? d * 0.03 : d / 0.06)
                .limit(5)
                .toArray();
    }
}

public class MyTemplate {
    public static void main(String[] args) {
        Template factorial = new Factorial();
        factorial.template();
        System.out.println(Arrays.toString(factorial.doInts()));
        System.out.println(Arrays.toString(factorial.doDoubles()));

        Template linear = new Linear();
        linear.template();
        System.out.println(Arrays.toString(linear.doInts()));
        System.out.println(Arrays.toString(linear.doDoubles()));

        Template something = new SomethingElse();
        something.template();
        System.out.println(Arrays.toString(something.doInts()));
        System.out.println(Arrays.toString(something.doDoubles()));
    }
}
