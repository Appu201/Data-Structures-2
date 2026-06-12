package Queue;

import java.util.*;
public class RevKEle {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(5);
        q.offer(6);
        q.offer(7);
        q.offer(8);
        q.offer(9);
        q.offer(10);
        q.offer(11);
        q.offer(12);
        

        int k = 4;

        System.out.println(q);

        Stack<Integer> s = new Stack<>();

        for(int i=0; i<k; i++) {
            s.push(q.poll());
        }

        while(!s.isEmpty()) {
            q.offer(s.pop());
        }

        int rem = q.size()-k;

        for(int i=0; i<rem; i++) {
            q.offer(q.poll());
        }

        System.out.println(q);
    }
}