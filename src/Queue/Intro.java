package Queue;
import java.util.*;
public class Intro {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(5);
		q.offer(6);
		q.offer(7);
		q.offer(8);
		System.out.println(q);
		
		q.poll();
		System.out.println(q);
		
		System.out.println(q.peek());
		System.out.println(q.element());
		System.out.println(q.size());
		System.out.println(q.isEmpty());
		
		
	}

}
