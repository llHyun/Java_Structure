import java.util.ArrayDeque;
import java.util.Deque;

public class Queue_Deque {
    public static void main(String[] args) {
        Deque<String> queue = new ArrayDeque<>();

        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");

        System.out.println(queue); // [a, b, c, d, e]

        System.out.println(queue.poll()); // a
        System.out.println(queue.poll()); // b

        System.out.println(queue); // [c, d, e]
    }


}
