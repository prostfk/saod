package by.bntu.fitr.prostrmk;

import java.util.*;

public class Graph {

    private final int VERTEX_MAX = 100;
    private Top[] vertexList;
    private int vertexCount;
    private Queue<Integer> queue;
    private int[][] matrix;

    public Graph() {
        queue = new ArrayDeque<>(100);
        matrix = new int[VERTEX_MAX][VERTEX_MAX];
        for (int i = 0; i < VERTEX_MAX; i++)
            for (int j = 0; j < VERTEX_MAX; j++)
                matrix[i][j] = 0;
        vertexCount = 0;
        vertexList = new Top[VERTEX_MAX];
    }

    public void addTop(String label) {
        vertexList[vertexCount++] = new Top(label);
    }

    public void addEdge(int begin, int end) {
        matrix[begin][end] = 1;
        matrix[end][begin] = 0;
    }

    public void detour(int v) {
        vertexList[v].setVisited(true);
        queue.add(v);
        int vertex;
        System.out.println(vertexList[v].getLabel());
        for (Integer integer : queue) {
            int current = integer;
            while ((vertex = getSuccessor(current)) != -1){
                vertexList[vertex].setVisited(true);
                queue.add(vertex);
                System.out.println(vertexList[vertex].getLabel());
            }
        }
        for (int i = 0; i < vertexCount; i++) {
            vertexList[i].setVisited(false);
        }
    }

    private int getSuccessor(int v) {
        for (int j = 0; j < vertexCount; j++)
            if (matrix[v][j] == 1 && !vertexList[j].isVisited())
                return j; //возвращает первую найденную вершину
        return -1; //таких вершин нет
    }


}
