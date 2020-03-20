package eg.edu.alexu.csd.datastructure.LinkedLists;

public class SingleLinkedList implements ILinkedList {
    public class Node {
        public Object value;
        public Node next = null;
        public Node(Object element) {
            this.value = element;
        }
    }

    private Node head;
    private int size;

    public SingleLinkedList() {
        this.size = 0;
    }

    @Override
    public void add(int index, Object element) {
        // check index and null
        if (index>size||index<0){
            return;
        }
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node i = head;
            for (int count = 0; count < index - 1; count++) {
                i = i.next;
            }
            newNode.next = i.next;
            i.next = newNode;
        }
        size++;
    }

    @Override
    public void add(Object element) {
        add(size, element);
    }

    @Override
    public Object get(int index) {
        // check index
        if (index>size||index<0){
            return null;
        }
        Node curr = head;
        for (int count = 0; count < index; count++) {
            curr = curr.next;
        }
        return curr.value;
    }

    @Override
    public void set(int index, Object element) {
        if (index>size||index<0){
            return;
        }
        Node j;
        Node newNode = new Node(element);
        if (index == 0) {
            j = head;
            head = newNode;
            newNode.next = j.next;
        } else {
            Node i = head;
            for (int count = 1; count < index; count++) {
                i = i.next;
            }
            j = i.next;
            i.next = newNode;
            newNode.next = j.next;
        }
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(int index) {
        // validation
        if (index>size||index<0){
            return;
        }
        if (size==1){
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node prev = head;
            for (int count = 0; count < index - 1; count++) {
                prev = prev.next;
            }
            Node nodeToRemove = prev.next;
            prev.next = nodeToRemove.next;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ILinkedList sublist(int fromIndex, int toIndex) {
        if (0>fromIndex||fromIndex>size||0>toIndex||toIndex>size){
            return null;
        }
        int size = toIndex - fromIndex + 1;
        Node i = head;
        for (int j = 0; j < fromIndex; j++) {
            i = i.next;
        }
        ILinkedList sublist = new SingleLinkedList();
        for (int j = 0; j < size; j++) {
            sublist.add(i.value);
            i = i.next;
        }
        return sublist;
    }

    @Override
    public boolean contains(Object o) {
        Node i = head;
        while (i != null) {
            if (i.value.equals(o)) {
                return true;
            }
            i = i.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
