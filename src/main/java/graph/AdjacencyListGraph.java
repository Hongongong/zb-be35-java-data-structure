package graph;

import java.util.*;

public class AdjacencyListGraph {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(Arrays.asList(

                // 연결된 노드 적는 순서는 상관없음, 단지 보기 좋게 오름차순 작성
                new ArrayList<>(Arrays.asList(1, 3)),
                new ArrayList<>(Arrays.asList(2, 4)),
                new ArrayList<>(Arrays.asList(1)),
                new ArrayList<>(Arrays.asList(4, 6)),
                new ArrayList<>(Arrays.asList(5)),
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(7)),
                new ArrayList<>(Arrays.asList())

        ));

        for(int start = 0; start < graph.size(); start++) {
            System.out.println(start + " - " + graph.get(start));
        }

    }

}
