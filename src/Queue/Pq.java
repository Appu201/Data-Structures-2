package Queue;
import java.util.*;

public class Pq {

    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.offer("b");
        pq.offer("a");
        pq.offer("d");

        while(!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }

//		int n=pq.size();
//		for(int i=0; i<n;i++) {
//			System.out.println(pq.poll()+" ");
//      }
        
    }
}