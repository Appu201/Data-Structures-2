package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAvg {
    Queue<Integer> q;
    int size;
    double sum;

    public MovingAvg(int size) {
        this.size = size;
        q = new LinkedList<>();
        sum = 0;
    }

    public double operation(int val) {
        q.offer(val);
        sum = sum + val;

        if (q.size() > size) {
            sum = sum - q.poll();
        }

        return sum/q.size();
    }

    public static void main(String[] args) {
        MovingAvg ma = new MovingAvg(3);

        System.out.println(ma.operation(1));
        System.out.println(ma.operation(10));
        System.out.println(ma.operation(3));
        System.out.println(ma.operation(5));
    }
}