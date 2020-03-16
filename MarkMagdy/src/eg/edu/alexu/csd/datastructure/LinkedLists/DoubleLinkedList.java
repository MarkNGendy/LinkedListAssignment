package eg.edu.alexu.csd.datastructure.LinkedLists;
public class DoubleLinkedList implements ILinkedList{
private DoubleNode head ;
private DoubleNode tail ;
private int size ;

public class DoubleNode {
    private Object value;
    private DoubleNode next;
    private DoubleNode prev;

    public DoubleNode (Object element){
        this.value = element;
    }


    public DoubleNode() {
        this.next = null;
        this.prev = null;
    }
}
public DoubleLinkedList(){
    this.size = 0;
}
    @Override
    public void add(int index, Object element) {
        DoubleNode newnode = new DoubleNode(element);
        if (index==0){
            newnode.next = head;
            newnode.prev = null;
            head = newnode;
        }
        else {
            DoubleNode i = head;
            for (int count = 0; count < index - 1; count++) {
                i = i.next;
            }
            newnode.next = i.next;
            newnode.prev = i;
            i.next = newnode;
        }
        size++;
    }

    @Override
    public void add(Object element) {
        add(size,element);
    }

    @Override
    public Object get(int index) {
        // check index
        DoubleNode curr = head;
        for (int count = 0; count < index; count++) {
            curr = curr.next;
        }
        return curr.value;
    }

    @Override
    public void set(int index, Object element) {
        DoubleNode newnode = new DoubleNode(element);
        DoubleNode j;
    if (index == 0){
            j = head;
            newnode.next = j.next;
            newnode.prev = null;
            head = newnode;
        }
    else {
        DoubleNode i = head;
        for (int count = 1; count < index; count++) {
            i = i.next;
        }
        j = i.next;
        newnode.next = j.next;
        newnode.prev = i;
        i.next = newnode;
        i = j.next;
    }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(int index) {
        if (index == 0){
            head = head.next;
        }
        else {
            DoubleNode i = head;
            for (int count = 1 ; count<index ; count++){
                i =i.next;
            }
            DoubleNode j = i.next;
            i.next = j.next;
            j.prev = i;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ILinkedList sublist(int fromIndex, int toIndex) {
        return null;
}

    @Override
    public boolean contains(Object o) {
        DoubleNode i = head;
        while (i != null) {
            if (i.value.equals(o)) {
                return true;
            }
            i = i.next;
        }
        return false;
    }
    //display() will print out the nodes of the list
    public void display() {
        //Node current will point to head
        DoubleNode current = head;
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while(current != null) {
            //Prints each node by incrementing the pointer.

            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList d = new DoubleLinkedList();
        d.add(0,5);
        d.add(1,2);
        d.add(2,9);
        d.add("m");
        //d.remove(3);
        d.display();
    }
}
