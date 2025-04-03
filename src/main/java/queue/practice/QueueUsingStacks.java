package queue.practice;

import java.util.*;
import java.io.*;

public class QueueUsingStacks {

    public static class Queue {

        private Stack<Integer> saveStack; // 데이터 저장하는 스택
        private Stack<Integer> likeQueue; // 데이터 꺼내는 스택

        // 생성자
        public Queue() {
            this.saveStack = new Stack<>();
            this.likeQueue = new Stack<>();
        }

        // 데이터 삽입
        public void enqueue(int value) {

            this.saveStack.push(value);

        }

        // 데이터 삭제 (꺼내서 확인)
        public int dequeue() {

            // likeQueue가 비어있고 saveQueue도 비어있으면 true && true => true => -1 반환
            // saveStackToLikeQueue() 를 수행했을때 saveStack이 비어있지 않으면 likeQueue로 데이터 옮기고 true를 반환
            // true && false => false 되서 dequeue 정상 수행됨
            // isEmpty() 가 false면 saveStackToLikeQueue() 는 아애 수행 안하고 if문 종료됨
            if(likeQueue.isEmpty() && !saveStackToLikeQueue()) {
                return -1; // 큐가 비어있기 때문에 에러값 반환
            }

            return likeQueue.pop();

        }

        // 데이터 확인 (안 꺼냄)
        public int peek() {

            // 두 스택 모두 비어 있으면 큐가 비어 있는 상태 → -1 반환
            if(likeQueue.isEmpty() && !saveStackToLikeQueue()) {
                return -1;
            }

            return likeQueue.peek();

        }


        // saveStack에 있는 데이터를 likeQueue로 옮겨주는 메서드
        // saveStack이 비어 있으면 false 반환 (즉, 큐가 비어있다는 의미)
        private boolean saveStackToLikeQueue() {

            // 저장하는 스택이 비어있을때
            if(saveStack.isEmpty()) {
                System.out.println("큐가 비어있습니다.");
                return false; // 바로 종료
            }

            // 저장하는 스택이 비어있지 않을때
            while(!saveStack.isEmpty()) {

                likeQueue.push(saveStack.pop());

            }

            return true; // 정상 종료
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
