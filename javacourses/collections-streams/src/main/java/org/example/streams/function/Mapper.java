package org.example.streams.function;

@FunctionalInterface
public interface Mapper<T, R> {

    R map(T t);
}
