package Queue;
import java.util.*;

public class Deq {

	public static void main(String[] args) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offerLast(5);
		dq.offerFirst(6);
		dq.offerLast(7);
		dq.offerFirst(8);
		System.out.println(dq);
		dq.pollFirst();
		System.out.println(dq);
		dq.pollLast();
		System.out.println(dq);
	}

}
