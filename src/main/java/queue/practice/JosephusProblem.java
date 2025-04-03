package queue.practice;

/*
* N개의 인원이 둥글게 앉아있으며, 1번부터 N번의 숫자가 주어져있습니다.
* 1번부터 퇴실하며, 다음은 M번 떨어진 인원이 순서대로 퇴실합니다.
* 이때, 떨어진 자리는 자리가 아닌 인원으로 판단할 때 퇴실하는 인원의 번호를 순서대로 출력하세요.
* */

import java.util.*;
import java.io.*;

public class JosephusProblem {

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            // 사용자 입력 받아서 저장
            String[] inputData = br.readLine().split(" ");
            int N = Integer.parseInt(inputData[0]);
            int M = Integer.parseInt(inputData[1]);

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 1; i <= 10; i++) {
                queue.offer(i);
            }

            StringBuilder sb = new StringBuilder();

            // 모든 인원 퇴실할때까지
            while(!queue.isEmpty()) {
                sb.append(queue.poll()).append(" "); // 큐 front 부터 순차적으로 퇴실

                // 모든 인원 퇴실하면 종료
                if(queue.isEmpty()) break;

                // M명 넘기기
                for(int m = 1; m < M; m++) {
                    // front에서 빼서 다시 rear로 삽입
                    queue.offer(queue.poll());
                }
            }

            System.out.println(sb.toString());

        }

    }

}
