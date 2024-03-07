//무방향 그래프(인접 리스트)
import java.util.ArrayList;

public class Graph_list {
    public static void print(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 1; i < graph.size(); i++) {
            ArrayList<Integer> node = graph.get(i);
            System.out.print("node"+"["+i+"] : ");
            for (int j = 0; j < node.size(); j++)
                System.out.print(node.get(j)+ "->");
            System.out.println();
        }
    }
    //무방향 그래프
    public static void UnDirected(ArrayList<ArrayList<Integer>> graph, int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
    //방향 그래프
    public static void Directed(ArrayList<ArrayList<Integer>> graph, int x, int y) {
        graph.get(x).add(y);
    }

    //가중치 그래프는 모르겠습니다.

    public static void main(String[] args) {
        int n = 5; //그래프 정점의 개수
        ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            graph1.add(new ArrayList<>()); //각 노드 별 리스트를 만들어준다.
        UnDirected(graph1, 1, 2);
        UnDirected(graph1, 1, 3);
        UnDirected(graph1, 1, 4);
        UnDirected(graph1, 2, 3);
        UnDirected(graph1, 2, 5);
        UnDirected(graph1, 3, 4);
        UnDirected(graph1, 4, 5);

        for (int i = 0; i <= n; i++)
            graph2.add(new ArrayList<>()); //각 노드 별 리스트를 만들어준다.
        Directed(graph2, 1, 2);
        Directed(graph2, 2, 1);
        Directed(graph2, 2, 5);
        Directed(graph2, 3, 4);
        Directed(graph2, 4, 1);
        Directed(graph2, 5, 3);


        print(graph1);
        System.out.println("=========");
        print(graph2);

    }
}
