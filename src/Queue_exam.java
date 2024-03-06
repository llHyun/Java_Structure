import java.util.Queue;
import java.util.LinkedList;

public class Queue_exam {
    Queue<String> nameof = new LinkedList<>();

    public static void main(String[] args) {
        Queue_exam queue_exam = new Queue_exam();

        queue_exam.nameof.add("first");
        queue_exam.nameof.offer("second");
        queue_exam.nameof.offer("third");
        queue_exam.nameof.offer("fourth");

        System.out.println(queue_exam.nameof);

        queue_exam.nameof.poll();
        queue_exam.nameof.remove("third");

        System.out.println(queue_exam.nameof);

        System.out.println(queue_exam.nameof.peek());
        System.out.println(queue_exam.nameof.element());

        System.out.println(queue_exam.nameof.size());

        if (queue_exam.nameof.contains("fourth")) {
            queue_exam.nameof.clear();
        }
        System.out.println(queue_exam.nameof.isEmpty());
    }

}
