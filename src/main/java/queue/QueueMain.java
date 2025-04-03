package queue;

import java.io.*;
import java.util.*;

public class QueueMain {

    public static class Queue {

        private int[] arr; // 큐 배열
        private int front, rear, size; // 앞/뒤 인덱스, 큐 사이즈

        // 생성자
        public Queue() {

            this.arr = new int[10];
            this.front = 0;
            this.rear = -1;
            this.size = 0;

        }

        // 큐에 데이터 삽입
        public void enqueue(int value) {

            // 큐 배열 이미 다 찼다면
            if(size == arr.length) {
                System.out.println("현재 큐가 가득 찼습니다.");
                return;
            }

            // 큐 끝으로 데이터 삽입 (rear+1 인덱스에 삽입)
            this.arr[(++rear) % arr.length] = value;
            size++; // 큐 사이즈 + 1

        }

        // 데이터 삭제
        public void dequeue() {

            // 큐 비어있으면 바로 종료
            if(size == 0) {
                System.out.println("큐가 비어있습니다.");
                return;
            }

            front++; // front 인덱스 값 + 1
            size--; // 큐 사이즈 - 1

        }

        // 데이터 가져오기 (확인)
        public int peek() {

            if (size == 0) {
                System.out.println("큐가 비어있습니다.");
                return -1;
            }

            return arr[front % arr.length];

        }

        // 큐 배열 전체 출력 (실제 큐 인터페이스에는 없음)
        public void printQueue() {

            StringBuilder sb = new StringBuilder();
            for(int data : arr) {
                sb.append(data).append(" ");
            }
            System.out.println(sb.toString());

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue queue = new Queue();
        for(int i = 1; i <= 10; i++) {
            queue.enqueue(10 * i);
        }
        queue.printQueue(); // 10 20 30 40 50 60 70 80 90 100

        queue.enqueue(200); // 현재 큐가 가득 찼습니다.
        queue.printQueue(); // 10 20 30 40 50 60 70 80 90 100

        System.out.println(queue.peek()); // 10

        for(int i = 0; i < 10; i++) {
            queue.dequeue();
            System.out.println("Peek : " + queue.peek()); // 20 부터 100 까지 출력
            queue.printQueue(); // 10 20 30 40 50 60 70 80 90 100

            // 마지막에
            // ArrayIndexOutOfBoundsException 예외 발생
            // 배열 크기 한계 극복위해 front, rear에 나머지 연산자(%) 사용해서 원형큐로 사용
        }


    }

}
