package Queue;

import java.util.*;
public class ReverseAQueue {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(5);
        q.offer(6);
        q.offer(7);
        q.offer(8);
        System.out.println(q);
        
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()) {
            s.push(q.poll());
        }
        
        while(!s.isEmpty()) {
            q.offer(s.pop());
        }
        
        System.out.println(q);
    }
}