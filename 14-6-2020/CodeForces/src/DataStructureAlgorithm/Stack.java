package DataStructureAlgorithm;

import com.sun.org.apache.xpath.internal.objects.XObject;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class Node<T> {
        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.next = trav.prev = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T elem) {
        addLast(elem);
    }

    public void addFirst(T elem) {
        if (isEmpty())
            head = tail = new Node<T>(elem, null, null);
        else {
            head.prev = new Node<T>(elem, null, this.head);
            head = head.prev;
        }
        size++;
    }

    public void addLast(T elem) {
        if (isEmpty())
            head = tail = new Node<T>(elem, null, null);
        else {
            tail.next = new Node<T>(elem, this.tail, null);
            tail = tail.next;
        }
        size++;
    }

    public T peekFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        return tail.data;
    }

    public T removeFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        T dataBeforeDeleted = head.data;
        head = head.next;
        size--;
        if (isEmpty()) tail = null;
        else head.prev = null;
        return dataBeforeDeleted;
    }

    public T removeLast() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        T dataBeforeDeleted = tail.data;
        tail = tail.prev;
        size--;
        if (isEmpty()) head = null;
        else tail.next = null;
        return dataBeforeDeleted;
    }

    public T remove(Node<T> node) {
        if (isEmpty())
            throw new RuntimeException("Empty list");

        if (node.prev == null) return removeFirst();
        if (node.next == null) return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;
        //Just Memory clean up
        node = node.next = node.prev = null;

        --size;
        return data;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        Node<T> trav;
        if (index < size / 2) {
            for (int i = 0, trav = head; i != index; i++) {
                trav = trav.next;
            }
        } else {
            for (int i = size - 1, trav = tail; i != index; i--) {
                trav = trav.next;
            }
        }
        --size;
        return remove(trav);
    }

    public boolean remove(Object obj) {
        Node<T> trav = head;
        //Suppose Searching for null
        if (obj == null) {
            for (trav = head, trav != null; trav = trav.next)
                if (trav.data == null) {
                    remove(trav);
                    return null;
                }

        } else {
            for (trav = head, trav != null; trav = trav.next) {
                if (obj.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }

        }
        return false;
    }


    public int indexOf(Object obj) {

        Node<T> trav;
        if (obj == null) {
            for (int index = 0, trav = head; trav != null; trav = trav.next, index++)
                if (trav.data == null)
                    return index;

        } else
            for (int index = 0, trav = head; trav != null; trav = trav.next, index++)
                if (obj.equals(trav.data))
                    return index;

        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

/////////****************************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\
/////////****************************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\
/////////****************************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\

}
