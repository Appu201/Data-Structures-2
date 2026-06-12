package SinglyLinkedList;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {
    ListNode head;

    void removeLoop() {
        ListNode slow = head;
        ListNode fast = head;
        boolean loopExists = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                loopExists = true;
                break;
            }
        }

        if (!loopExists) {
            System.out.println("No loop found");
            return;
        }

        fast = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode loopStart = slow;
        ListNode temp = loopStart;

        while (temp.next != loopStart) {
            temp = temp.next;
        }

        temp.next = null;
        System.out.println("Loop removed");
    }

    void display() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}

public class RemoveLoop {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(5);
        list.head.next.next.next.next.next = new ListNode(6);

        list.head.next.next.next.next.next.next =
                list.head.next.next.next;

        list.removeLoop();
        list.display();
    }
}