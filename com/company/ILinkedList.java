package com.company;

public interface ILinkedList<E> extends Iterable<E> {
    void add(E element);
    void add(int index, E element);
    void clear();
    E get(int index);
    void remove(int index);
    E set(int index, E element);
    int size();
    E[] toArray();
    String toString();
}
