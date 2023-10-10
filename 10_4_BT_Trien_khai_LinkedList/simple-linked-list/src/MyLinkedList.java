import org.w3c.dom.Node;

import java.util.LinkedList;

public class MyLinkedList<E> {
    private LinkedList<E> myList = new LinkedList<>();
    private E type;
    private Node head;
    private int numNodes = 10;

    public void MyLinkedList(E element) {
        this.type = element;
    }

    public void add(int index, E element) {
        myList.add(index, element);
    }
    public void addFirst(E element) {
        myList.addFirst(element);
    }

    public void addLast (E element) {
        myList.addLast(element);
    }

    public E remove(int index) {
        return myList.remove(index);
    }
    public boolean remove(Object e) {
        return remove(e);
    }
    public int size() {
        return myList.size();
    }
    @Override
    public E clone() {
        return (E) myList.clone();
    }

    public boolean contains (E o) {
        return myList.contains(o);
    }
    public int indexOf(E o) {
        return myList.indexOf(o);
    }
    public boolean add(E e) {
        return myList.add(e);
    }

    public void ensureCapacity(int minCapacity) {

    }
    public E get(int i) {
        return (E) myList.get(i);
    }
    public E getFirst() {
        return (E) myList.getFirst();
    }
    public E getLast() {
        return (E) myList.getLast();
    }
}