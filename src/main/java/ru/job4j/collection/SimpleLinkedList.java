package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LinkedList<E> {
    private int modCount = 0;
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void add(E value) {
        Node<E> l = last;
        Node<E> node = new Node<>(value, null);
        last = node;
        if (l == null) {
            first = node;
        } else {
            l.next = node;
        }
            size++;
            modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> nod = first;
        for (int i = 0; i < index; i++) {
            nod = nod.next;
        }
        return nod.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> node = first;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E e = node.element;
                node = node.next;
                return e;
            }
        };
    }
}
