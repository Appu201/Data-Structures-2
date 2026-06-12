package Stack;
import java.util.Stack;
public class Intro {
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		
		st.push(5);
		st.push(4);
		st.push(3);
		st.push(2);
		st.push(1);
		
		
		System.out.println("Stack: "+st);
		
		st.pop();
		
		System.out.println("Stack: "+st);
		
		System.out.println("Peek: "+st.pop());
		
		System.out.println(st.isEmpty());
		System.out.println(!st.isEmpty());
	}
}
