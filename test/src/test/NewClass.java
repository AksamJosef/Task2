package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NewClass {
    public static void main(String[] args) {
        List<Example> stringList = new ArrayList<>();

        stringList.add(new Example("r", "a"));
        stringList.add(new Example("z", "z"));
        stringList.add(new Example("d", "d"));
        stringList.add(new Example("n", "c"));
        stringList.add(new Example("b", "b"));


        List<Example> collect = stringList.stream().sorted(Comparator.comparing(x -> x.value)).collect(Collectors.toList());

        collect.add(new Example("b", "r"));

        collect.stream()
                .sorted(Comparator.comparing(x -> x.key))
                .forEach(System.out::println);
    }
}

class Example {
    String key;
    String value;

    public Example(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Example{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
