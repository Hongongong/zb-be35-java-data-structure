package graph;

import java.util.ArrayList;
import java.util.Arrays;

// 가중치 있는 인접 리스트 그래프

// 정점 클래스 (Vertex or Node)
class Vertex {

    int v; // 현재 번호
    int w; // 가중치

    public Vertex(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "v=" + v +
                ", w=" + w +
                '}';
    }
}

public class WeightedAdjacencyListGraph {


    public static void main(String[] args) {

        ArrayList<ArrayList<Vertex>> graph = new ArrayList<>(Arrays.asList(

                // 정점(Vertex or Node)에 가중치도 함께 저장
                new ArrayList<>(Arrays.asList(new Vertex(1, 3), new Vertex(3, 4))),
                new ArrayList<>(Arrays.asList(new Vertex(2, 1), new Vertex(4, 2))),
                new ArrayList<>(Arrays.asList(new Vertex(1, 7))),
                new ArrayList<>(Arrays.asList(new Vertex(4, 8), new Vertex(6, 5))),
                new ArrayList<>(Arrays.asList(new Vertex(5, 9))),
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(new Vertex(7, 6))),
                new ArrayList<>(Arrays.asList())

        ));

        for(int start = 0; start < graph.size(); start++) {
            System.out.println(start + " - " + graph.get(start));
        }

    }

}
