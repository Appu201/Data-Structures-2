package DoublyLinkedList;

public class Intro {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.addAtHead(10);
        list.addAtTail(20);
        list.addAtTail(30);
        list.addAtIndex(1, 15);

        list.displayForward();
        list.displayBackward();

        System.out.println(list.get(2));

        list.deleteAtIndex(1);

        list.displayForward();
    }
}