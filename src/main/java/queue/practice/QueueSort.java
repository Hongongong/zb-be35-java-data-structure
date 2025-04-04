package queue.practice;

/*
* 큐 2개를 이용해서, 오름차순 정렬을 해보세요.
* 큐 1개도 가능하다고 1개로 문제풀이함!
* 큐로 정렬하는건 효율적인 연산은 아님, 할수있다고 생각하자.
* */

import java.io.*;
import java.util.*;

public class QueueSort {

    // 큐 1개로 오름차순 정렬
    public static void sortQueue(Queue<Integer> originalQueue) {

        int size = originalQueue.size(); // 큐 처음 사이즈

        for(int i = 0; i < size; i++) {
            int now = originalQueue.poll(); // 큐 front 요소 뺌

            int innerSize = originalQueue.size(); // front 요소 하나 뺀 후의 큐 사이즈
            // innerSize 만큼 반복
            for(int j = 0; j < innerSize; j++) {

                int temp = originalQueue.poll(); // 큐 front 요소 뺌 ( now 와는 다름)

                // 작은값은 queue 뒤로 보내고 큰값을 now로 변경
                // temp가 now 보다 작으면
                if(temp < now) {
                    originalQueue.offer(temp); // temp 값을 큐 끝으로 삽입
                } else { // now가 temp보다 작으면
                    originalQueue.offer(now); // now 값을 큐 끝으로 삽입
                    now = temp; // now를 temp 값으로 변경
                }

            }

            originalQueue.offer(now); // now 값을 큐 끝으로 삽입
        }

    }

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] inputData = br.readLine().split(" ");

            Queue<Integer> queue = new LinkedList<>();
            for(String data : inputData) {

                queue.offer(Integer.parseInt(data));

            }

            // 오름차순 정렬 (Queue는 선입선출이므로 넣은대로 나옴)
            sortQueue(queue);

            StringBuilder sb = new StringBuilder();
            while(!queue.isEmpty()) {
                sb.append(queue.poll()).append(" ");
            }

            System.out.println(sb.toString());

        }

    }

}
