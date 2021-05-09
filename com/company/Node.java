package com.company;

public class Node<E>
{
    E element;
    Node<E> nextNode;
    Node<E> followNode;

    public Node(E element, Node<E> nextNode, Node<E> followNode) {
        this.element = element;
        this.nextNode = nextNode;
        this.followNode = followNode;

    }

    public boolean hasNext() {
        return this.nextNode != null;

    }
}
