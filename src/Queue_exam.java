import java.util.Queue;
import java.util.LinkedList;

public class Queue_exam {
    Queue<String> nameof = new LinkedList<>();

    public void main(String[] args){
        nameof.add("first");
        nameof.offer("second");
        nameof.offer("third");
        nameof.offer("fourth");

        System.out.println(nameof);

        nameof.poll();
        nameof.remove("third");



        System.out.println(nameof);

        System.out.println(nameof.peek());
        System.out.println(nameof.element());

        System.out.println(nameof.size());


        if(nameof.contains("fourth")){
            nameof.clear();
        }
        System.out.println(nameof.isEmpty());

    }
}
