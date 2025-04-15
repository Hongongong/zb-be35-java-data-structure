package programmers.week7.prob1;

import java.util.*;

public class Solution {

    public static int solution(int N, int[][] edges) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // 노드 수만큼 빈 리스트 초기화 (노드 N+1개 생성됨, 1-based index)
        for(int i = 0; i<= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 방향 엣지 연결
        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(to);
        }

        for(int start = 0; start < graph.size(); start++) {
            System.out.println(start + " - " + graph.get(start));
        }

        int current = 1;
        int count = 0;

        while(current == 13) {
            if(graph.get(current).size() == 1) {
                count++;
                current = graph.get(current).get(0);
            }
        }

        return 0;

    }

    public static void main(String[] args) {

        int[][] arr = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {4, 7},
                {5, 7}, {6, 5}, {6, 8}, {7, 9}, {8, 10}, {9, 10}, {10, 11}, {11, 12}, {12, 13}};

        System.out.println(solution(13, arr));

    }

}
