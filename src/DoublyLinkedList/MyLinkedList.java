package DoublyLinkedList;

public class MyLinkedList {

    class Node{
        int val;
        Node prev;
        Node next;
        Node(int val){
            this.val=val;
            prev=null;
            next=null;
        }
    }

    Node head;
    Node tail;
    int cnt;

    public MyLinkedList() {
        head=tail=null;
        cnt=0;
    }
    
    public int get(int index) {
        if(index<0 || index>=cnt){
            return -1;
        }
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node nn=new Node(val);
        if(head==null){
            head=tail=nn;
        }else{
            nn.next=head;
            head.prev=nn;
            head=nn;
        }
        cnt++;
    }
    
    public void addAtTail(int val) {
        Node nn=new Node(val);
        if(head==null){
            head=tail=nn;
        }else{
            tail.next=nn;
            nn.prev=tail;
            tail=nn;
        }
        cnt++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0 || index>cnt) return;
        if(index==0){
            addAtHead(val);
            return;
        }
        if(index==cnt){
            addAtTail(val);
            return;
        }

        Node nn=new Node(val);
        Node temp=head;

        for(int i=0;i<index;i++){
            temp=temp.next;
        }

        Node prevNode=temp.prev;

        prevNode.next=nn;
        nn.prev=prevNode;

        nn.next=temp;
        temp.prev=nn;

        cnt++;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=cnt) return;

        if(cnt==1){
            head=tail=null;
        }
        else if(index==0){
            head=head.next;
            head.prev=null;
        }
        else if(index==cnt-1){
            tail=tail.prev;
            tail.next=null;
        }
        else{
            Node temp=head;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }

            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;
        }

        cnt--;
    }

    public void displayForward() {
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        Node temp=tail;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.prev;
        }
        System.out.println();
    }
}