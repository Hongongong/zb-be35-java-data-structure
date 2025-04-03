package queue.practice;

import java.util.*;

public class QueueUsingList {

    public static class Queue {

        private LinkedList<Integer> list;

        // 생성자
        public Queue() {
            this.list = new LinkedList<>();
        }

        // 데이터 삽입
        public void enqueue(int value) {

            // list.add(value); // boolean 반환
            list.addLast(value); // add() 와 같이 list 끝에 데이터 삽입하지만 add와 달리 반환이 없음.

        }

        // 데이터 삭제 (꺼내서 확인)
        public int dequeue() {

            // 큐 비어있을때 에러 반환
            if (list.isEmpty()) {
                System.out.println("큐가 비어있습니다.");
                return -1;
            }

            return list.removeFirst(); // list 첫번째 요소 삭제하고 반환

        }

        // 데이터 확인 (안 꺼냄)
        public int peek() {

            // 큐 비어있을때 에러 반환
            if (list.isEmpty()) {
                System.out.println("큐가 비어있습니다.");
                return -1;
            }

            // return list.get(0); // list 0번재 요소 반환
            return list.getFirst(); // list 첫번재 요소 반환 (get과 같지만 명시적으로 적기위함)

        }

    }

    public static void main(String[] args) {

        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue()); // 1 (큐에서 제거하면서 가져옴)
        System.out.println(queue.peek()); // 2 (큐에서 제거하지않고 확인만)

        queue.enqueue(4);
        System.out.println(queue.dequeue()); // 2 (큐에서 제거하면서 가져옴)
        System.out.println(queue.dequeue()); // 3 (큐에서 제거하면서 가져옴)
        System.out.println(queue.dequeue()); // 4 (큐에서 제거하면서 가져옴)
        System.out.println(queue.dequeue()); // 큐가 비어있습니다. -1

    }

}
