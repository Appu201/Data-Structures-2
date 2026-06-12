package SinglyLinkedList;
import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
}

class LL{
    Node head=null,tail=null;

    void insertLast(int val){
        Node nn=new Node(val);
        if(head==null){
            head=nn;
            tail=nn;
        }else{
            tail.next=nn;
            tail=nn;
        }
    }

    void display(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("NULL");
    }
}

public class LinkedList{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int val;
        LL l=new LL();

        while(true){
            val=sc.nextInt();
            if(val==-1){
                break;
            }
            l.insertLast(val);
        }

        l.display();
        sc.close();
    }
}