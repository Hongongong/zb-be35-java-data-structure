package graph;

import java.util.ArrayList;
import java.util.Arrays;

// 인접 행렬 그래프 구현

public class AdjacencyMatrixGraph {

    public static void main(String[] args) {

        // 적당하게 큰수로 무한대 값 설정 (빈 엣지 인덱스에 저장할 값)
        final int INF = 987654321;

        // ArrayList<ArrayList<Integer>> graph = new ArrayList<>(List.of()); // 아래와 같으나 null 값 허용 안됨
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(Arrays.asList(
                // 노드 8개 이므로 8x8 인접 행렬 그래프 생성
                                            // A, B, C, D, E, F, G, H
                new ArrayList<>(Arrays.asList(INF, 1, INF, 1, INF, INF, INF, INF)), // A
                new ArrayList<>(Arrays.asList(INF, INF, 1, INF, 1, INF, INF, INF)), // B
                new ArrayList<>(Arrays.asList(INF, 1, INF, INF, INF, INF, INF, INF)), // C
                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, 1, INF, 1, INF)), // D
                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, 1, INF, INF)), // E
                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, INF, INF, INF)), // F
                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, INF, INF, 1)), // G
                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, INF, INF, INF)) // H

        ));

        for(int i = 0; i < graph.size(); i++) {
            System.out.println(graph.get(i));
        }

    }

}
