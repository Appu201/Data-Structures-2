package Stack;
import java.util.Stack;

class StackIntr {

    Stack<Integer> st = new Stack<>();

    public void push(int x) {
        st.push(x);
    }

    public int pop() {
        if (!st.isEmpty()) {
            return st.pop();
        }
        return -1;
    }

    public int peek() {
        if (!st.isEmpty()) {
            return st.peek();
        }
        return -1;
    }

    public boolean isEmpty() {
        return st.isEmpty();
    }
}

public class Intro2 {

    public static void main(String[] args) {

        StackIntr obj = new StackIntr();

        obj.push(10);
        obj.push(20);
        obj.push(30);

        System.out.println("Top: " + obj.peek());

        System.out.println("Popped: " + obj.pop());

        System.out.println("Is Empty: " + obj.isEmpty());
    }
}