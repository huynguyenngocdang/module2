import java.util.LinkedList;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    private class Node {
        private Node next;
        private Object data;
        private Node first;

        private Node last;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, E element) {
        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E e) {

    }

    public void addLast(E e) {

    }

    public E remove(int index) {

        return null;
    }

    public boolean remove(Object e) {

        return false;
    }

    public int size() {

        return 0;
    }

    @Override
    public E clone() {

        return null;
    }

    public boolean contains(E o) {

        return false;
    }

    public int indexOf(E o) {

        return 0;
    }

    public boolean add(E e) {

        return false;
    }

    public void ensureCapacity(int minCapacity) {

    }

    public E get(int i) {

        return null;
    }

    public E getFirst() {

        return null;
    }

    public E getLast() {
        return null;
    }

    public void clear() {

    }
}

