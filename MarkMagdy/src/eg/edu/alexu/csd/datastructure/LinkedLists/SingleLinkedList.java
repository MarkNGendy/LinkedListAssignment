package eg.edu.alexu.csd.datastructure.LinkedLists;

public class SingleLinkedList implements ILinkedList {
    private Node head = null;
    @Override
    public void add(int index, Object element) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node i = head;
            for (int count = 1; count < index; count++) {
                i = i.next;
            }
            newNode.next = i.next;
            i.next = newNode;
        }
    }

    @Override
    public void add(Object element) {
        Node i = head;
        Node newNode = new Node(element);
        while (i.next != null){
            i = i.next;
        }
        newNode.next = i.next;
        i.next = newNode;
    }

    @Override
    public Object get(int index) {
        Node i = head;
        if (index==0){
            return i.value;
        }
        for (int count = 1 ; count<index ; count++){
            i = i.next;
        }
        if (i.next == null){
            return null;
        }
        else {
            i = i.next;
            return i.value;
        }
    }

    @Override
    public void set(int index, Object element) {
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

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node i = head;
            Node j;
            for (int count = 1; count < index; count++) {
                i = i.next;
            }
            j = i.next;
            i.next = j.next;

        }
    }

    @Override
    public int size() {
        Node i = head ;
        int count = 0;
        while (i.next != null){
            count ++ ;
            i = i.next;
        }
        return count+1;
    }

    @Override
    public ILinkedList sublist(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        Node i =head;
        for (int count = 0 ; count < size(); count++){
            if (i.value == o){
                return true;
            }
            else {
                i = i.next;
            }
        }
        return false;
    }
    public void print(){
        Node i = head ;
        while (i != null){
            System.out.println(i.value);
            i = i.next;
        }
    }
    public static void main(String[] args) {
        SingleLinkedList single = new SingleLinkedList();
        single.add(0,5);
        single.add(1,'a');
        single.add(2,9);
        single.add("mark");
        single.print();
        // System.out.println(single.get(1));
        //single.set(0,'n');
        //single.print();
        single.remove(0);
        single.print();
        System.out.println(single.contains("mark"));
    }
}
