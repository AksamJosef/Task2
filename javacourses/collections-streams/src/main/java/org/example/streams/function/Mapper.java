package org.example.streams;

@FunctionalInterface
public interface Mapper<T, R> {

    R map(T t);
}
