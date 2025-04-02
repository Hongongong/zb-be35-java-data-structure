package list;

import java.util.Arrays;

public class LinkedList {

    public static class CustomLinkedList {

        private static class Node {
            int value;
            Node pointer;

            // Node 생성자
            public Node(int value) {
                this.value = value;
                this.pointer = null;
            }
        }

        private Node head; // LinkedList의 시작점
        private int size; // LinkedList의 사이즈

        // LinkedList 생성자
        public CustomLinkedList() {
            this.size = 0; // Linkedlis 사이즈 초기화
        }

        // 마지막에 데이터 삽입
        public void add(int value) {

            // 현재 리스트 비어있는 상태라면
            if(head == null) {
                head = new Node(value); // 데이터 들어간 노드 새로 만들어서 head로 설정
            } else {
                Node current = head; // 헤드 노드 가져옴

                // current 의 pointer가 null 아니면
                while(current.pointer != null) {
                    // current를 다음 노드로 설정
                    current = current.pointer;
                }

                // current == 현재 LinkedList의 마지막 노드
                current.pointer = new Node(value); // current 다음으로 새로운 노드 연결
            }

            size++; // LinkedList 사이즈 늘림
        }

        // 중간에 데이터 삽입
        public void add(int index, int value) {
            // 인덱스 유효범위 확인
            if(index < 0 || index > size) {
                System.out.println("인덱스 범위 초과");
                return;
            }

            Node newNode = new Node(value);

            // 첫번째로 삽입
            if(index == 0) {

                newNode.pointer = head; // 기존 노드를 새 노드 다음으로 설정
                head = newNode; // 새 노드를 헤드로 설정

            } else { // 중간에 삽입

                Node prev = head;
                // 삽입할 위치 직전 노드 가져올때까지 반복
                for(int i = 0; i < index - 1; i++) {
                    prev = prev.pointer;
                }

                // 순서 중요(다음 노드 먼저 연결 후 prev.pointer를 새 노드로 변경)
                newNode.pointer = prev.pointer; // 삽입할 위치 전 노드의 포인터를 새 노드에 저장(뒷 노드 연결)
                prev.pointer = newNode; // 전 노드의 포인터를 새 노드로 저장
            }

            size++; // list 사이즈 늘어남
        }

        // 마지막 데이터 삭제
        public void remove() {
            Node current = head;

            // 다음 노드가 있을 동안
            while(current.pointer != null) {

                // 다음 노드가 마지막이 아닐때 (다음 노드의 pointer가 null 이 아닐때)
                if(current.pointer.pointer != null) {

                    current = current.pointer; // current를 다음 노드로 설정

                } else { // 다음 노드가 마지막 일 때

                    current.pointer = null; // 현재 노드의 pointer를 null 로 설정 (연결 끊음)
                    size--; // list 사이즈 줄임
                    break;

                }

            }
        }

        // 중간 데이터 삭제
        public void remove(int index) {
            // 인덱스 유효범위 확인
            if(index < 0 || index > size) {
                System.out.println("인덱스 범위 초과");
                return;
            }

            // 삭제할 데이터가 첫번째라면
            if(index == 0) {
                head = head.pointer; // 헤드를 다음 노드로 설정
            } else {
                Node prev = head;
                // 삭제할 노드 직전 노드 가져오기
                for(int i = 0; i < index - 1; i++) {
                    prev = prev.pointer;
                }
                prev.pointer = prev.pointer.pointer; // 직전 노드의 pointer를 삭제할 노드의 pointer로 설정
            }

            size--; // list 사이즈 줄임
        }

        public int get(int index) {

            // 인덱스 유효 범위 체크 있으면 좋음

            Node current = head; // 헤드 노드로 시작

            /* 풀이방법 1)
            // 리스트 사이즈만큼 순회
            for(int i = 0; i < size; i++) {
                // 해당 index 순서 되면
                if(i == index) {
                    return current.value; // 해당 노드 값 반환
                }
                current = current.pointer; // 다음 노드로
            }

            return -1; // 잘못된 경우
             */

            // 풀이방법 2)
            // 애초에 index 까지만 list를 순회함
            for(int i = 0; i < index; i++) {
                current = current.pointer; // 다음 노드로
            }
            return current.value;

        }

        // 리스트 전체 출력
        public void print() {
            StringBuffer sb = new StringBuffer();
            sb.append("[");

            Node current = head;

            while(true) {
                sb.append(current.value); // sb에 데이터 추가
                if(current.pointer != null) sb.append(", "); // 다음 노드 있으면 , 추가
                current = current.pointer; // 다음 노드로 이동
                if(current == null) break; // 다음 노드 없으면 끝
            }

            sb.append("]");

            System.out.println(sb.toString());
        }

    }


    public static void main(String[] args) {

        CustomLinkedList list = new CustomLinkedList(); // LinkedList 생성

        list.add(10);
        list.add(20);
        list.add(30);
        list.print(); // [10, 20, 30]

        list.remove();
        list.print(); // [10, 20]

        System.out.println(list.get(1)); // 20

        list.add(30);
        list.print(); // [10, 20, 30]

        list.add(1, 15);
        list.print(); // [10, 15, 20, 30]

        list.remove(2);
        list.print(); // [10, 15, 30]

    }

}
