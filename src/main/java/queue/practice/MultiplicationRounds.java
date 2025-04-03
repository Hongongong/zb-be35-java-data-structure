package queue.practice;

/*
* 사용자에게 1부터 N까지의 값으로 시작합니다.
* 한 라운드를 지날때마다 값은 10배 증가하며, M의 값 이하의 값만 표출합니다.
* 각 라운드의 숫자와 개수, 값을 출력합니다.
* */

import java.io.*;
import java.util.*;

public class MultiplicationRounds {

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            // 사용자 입력 받기
            String[] inputData = br.readLine().split(" ");
            int N = Integer.parseInt(inputData[0]); // 1 ~ N
            int M = Integer.parseInt(inputData[1]); // M 이하의 값만 큐에 저장

            // 큐 생성
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 1; i <= N; i++) {
                queue.offer(i); // 1 ~ N 까지 값 삽입
            }

            StringBuilder sb = new StringBuilder(); // 출력 결과를 효율적으로 누적할 StringBuilder

            int round = 1; // 라운드

            // 큐 빌때 까지
            while(!queue.isEmpty()) {

                int queueSize = queue.size(); // 각 라운드 시작 시 큐 사이즈(요소 개수)

                sb.append(round).append("(").append(queueSize).append(") : "); // 1(6) :

                // 각 라운드 마다 요소 한번씩 다 poll - 출력
                for(int i = 0; i < queueSize; i++) {

                    int current = queue.poll(); // 요소 하나 꺼내기

                    sb.append(current).append(" "); // 요소 하나씩 출력

                    // 요소 * 10 값이 M 보다 작으면 큐에 삽입
                    if(current * 10 <= M) {
                        queue.offer(current * 10);
                    }

                }

                round++; // 다음 라운드로 이동

                sb.append("\n"); // 출력문 엔터

            }

            System.out.println(sb.toString()); // 결과 출력

        }

    }

}
