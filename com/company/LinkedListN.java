package com.company;
import java.util.Iterator;

public class LinkedListN<T> implements ILinkedList<T> {
    Node<T> firstElement = null;
    Node<T> lastElement = null;
    static int size = 0;

    @Override
    public void add(T element) {
        switch (size) {
            case 0 -> firstElement = new Node<>(element, null, null);
            case 1 -> {
                lastElement = new Node<>(element, null, firstElement);
                firstElement.nextNode = lastElement;
            }
            default -> {
                lastElement.nextNode = new Node<>(element, null, lastElement);
                lastElement = lastElement.nextNode;
            }
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        Node<T> next = fiend(index);
        if (index == 0) {
            firstElement.followNode = new Node<>(element, next, next.followNode);
            firstElement = firstElement.followNode;
        } else {
            next.followNode.nextNode = new Node<>(element, next, next.followNode);
            next.followNode = next.followNode.nextNode;
        }
        size++;
    }

    private Node fiend(int index) {
        Node<T> next = firstElement;
        for (int i = 0; i < index; i++) {
            next = next.nextNode;
        }
        return next;
    }

    @Override
    public void clear() {
        Node next = firstElement;
        for (int i = 0; i < size - 1; i++) {
            next = next.nextNode;
            next.followNode.nextNode = null;
            next.followNode = null;
        }
        firstElement = null;
        lastElement = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        return (T) fiend(index).element;
    }

    @Override
    public void remove(int index) {
        Node<T> delete = fiend(index);
        if (index == 0) {
            firstElement = firstElement.nextNode;
            firstElement.nextNode.followNode = null;
        } else {
            delete.followNode.nextNode = delete.nextNode;
            delete.nextNode.followNode = delete.followNode;
        }
        size--;

    }

    @Override
    public T set(int index, T element) {
        fiend(index).element = element;
        return (T) fiend(index).element;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public <T> T[] toArray(){
        T[] ARR = (T[]) new Object[size];
        for (int z = 0; z<size; z++){
         ARR[z] = (T) fiend(z).element;
        }
        return ARR;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int y = 0; y < this.size(); y++){
        sb.append(fiend(y).element);
        if (y == this.size()-1){
            sb.append(']');
            break;
        }
        sb.append(',');
        }

        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = firstElement;

            @Override
            public boolean hasNext() {
                return current.hasNext();
            }

            @Override
            public T next() throws IndexOutOfBoundsException {
                T result = current.element;
                if (!current.hasNext()) throw new IndexOutOfBoundsException("End of list.");
                current = current.nextNode;
                return result;
            }
        };
    }

}