//무방향 그래프( 인접 행렬 사용)
public class Graph_procession {
    public static void print(int[][] graph) {
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++)
                System.out.print(graph[i][j]+ " ");
            System.out.println();
        }
    }

    //무방향 그래프
    public static void UnDirected(int[][] graph, int x, int y) {
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    //방향 그래프
    public static void Directed(int[][] graph, int x, int y){
        graph[x][y] = 1;
    }

    //가중치 그래프
    public static void Weighted(int[][] graph, int x, int y, int value){
        graph[x][y] = value;
    }


    public static void main(String[] args){
        int n = 5; //그래프 정점의 개수
        int[][] graph1 = new int[n+1][n+1]; //index를 1부터 맞추기 위해 n+1
        int[][] graph2 = new int[n+1][n+1]; //index를 1부터 맞추기 위해 n+1
        int[][] graph3 = new int[n+1][n+1]; //index를 1부터 맞추기 위해 n+1

        //모든 간선을 연결한다면 완전 그래프가 됨
        UnDirected(graph1, 1, 2);
        UnDirected(graph1, 1, 3);
        UnDirected(graph1, 1, 4);
        UnDirected(graph1, 2, 3);
        UnDirected(graph1, 2, 5);
        UnDirected(graph1, 3, 4);
        UnDirected(graph1, 4, 5);

        //방향 그래프
        Directed(graph2, 1, 2);
        Directed(graph2, 2, 1);
        Directed(graph2, 2, 5);
        Directed(graph2, 3, 4);
        Directed(graph2, 4, 1);
        Directed(graph2, 5, 3);

        //가중치 그래프
        Weighted(graph3, 1, 2, 10);
        Weighted(graph3, 3, 1, 3);
        Weighted(graph3, 3, 2, 13);
        Weighted(graph3, 4, 1, 8);
        Weighted(graph3, 5, 4, 9);
        Weighted(graph3, 5, 2, 14);

        print(graph1);
        System.out.println("----------");
        print(graph2);
        System.out.println("----------");
        print(graph3);

    }



}
