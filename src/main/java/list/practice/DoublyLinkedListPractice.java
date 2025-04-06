package list.practice;

public class DoublyLinkedListPractice {

    // 양방향 연결 리스트
    public static class DoubleLinkedList {

        // 양방향 노드 클래스
        public static class Node {
            int data;
            Node prev;
            Node next;

            // 노드 생성자
            public Node(int data) {
                this.data = data;
                this.prev = null;
                this.next = null;
            }
        }

        // 리스트 시작 노드 포인터
        private Node head;
        // 리스트 끝 노드 포인터
        private Node tail;
        // 리스트 사이즈
        private int size;

        // 리스트 생성자
        public DoubleLinkedList() {

            this.head = null;
            this.tail = null;
            this.size = 0;

        }

        // 리스트 끝에 새 노드 추가
        public void add(int data) {
            Node newNode = new Node(data);

            // 리스트 비어있으면
            if(head == null) {
                // head, tail 모두 새 노드로 설정
                head = newNode;
                tail = newNode;
            } else { // 리스트 비어있지않으면
                // 새 노드를 tail 다음으로 연결
                tail.next = newNode;
                newNode.prev = tail; // 새 노드의 prev를 tail로 설정
                tail = newNode; // tail을 새 노드로 설정
            }
            size++; // 리스트 사이즈 + 1
        }

        // 리스트 맨앞에 새 노드 추가
        public void addFirst(int data) {
            Node newNode = new Node(data);

            // 리스트 비어있으면
            if(head == null) {
                // head, tail 모두 새 노드로 설정
                head = newNode;
                tail = newNode;
            } else { // 비어있지 않으면
                newNode.next = head; // 새 노드의 next 포인터를 기존 head로 설정
                head.prev = newNode; // 기존 head의 prev 포인터를 새 노드로 설정
                head = newNode; // head를 새 노드로 설정
            }

            size++; // 리스트 사이즈 + 1

        }

        // 특정 위치에 새 노드 추가
        public void add(int index, int data) {

            // index의 유효범위를 확인
            if(index < 0 || index > size) {
                System.out.println("인덱스가 유효하지 않습니다.");
                return;
            }

            // 추가할 인덱스가 0이면
            if(index == 0) {
                addFirst(data); // 맨앞 노드 추가 메소드 실행
                return;
            }

            // 추가할 인덱스가 리스트 size와 같으면
            if(index == size) {
                add(data); // 리스트 끝에 노드 추가 메소드 실행
                return;
            }

            // 해당 index에 새 노드 추가

            Node newNode = new Node(data); // 새 노드 생성
            Node current = head;
            // 해당 index 기존 노드까지 순회
            for(int i = 0; i < index; i++) {
                current = current.next;
            }

            newNode.next = current; // 해당 index 기존 노드를 새 노드의 next로 설정
            newNode.prev = current.prev; // 기존 노드의 prev를 새 노드의 prev로 설정
            current.prev.next = newNode; // 기존 노드의 prev 노드의 next를 새 노드로 설정
            current.prev = newNode; // 기존 노드의 prev를 새 노드로 설정

            size++; // 리스트 사이즈 + 1

        }

        // 리스트 끝 노드 삭제
        public void removeLast() {

            // 리스트 비어있으면 삭제할 노드가 없음
            if(size == 0) return;

            // 리스트에 노드 한개만 있을 경우
            if(head == tail) {
                head = null;
                tail = null;
            } else { // 그 외
                tail = tail.prev; // tail을 기존 tail의 앞 노드로 설정
                tail.next = null; // tail의 next 포인터를 null로 설정
            }

            size--; // 리스트 사이즈 - 1

        }

        // 리스트 첫번째 노드 삭제
        public void removeFirst() {
            // 노드 비어있는 경우
            if(size == 0) return;

            // 리스트에 노드 한개만 있는 경우
            if(head == tail) {
                head = null;
                tail = null;
            } else { // 그 외
                head = head.next; // head를 기존 head의 다음 노드로 설정
                head.prev = null; // head의 prev를 null로 설정
            }
        }

        // 특정 index의 노드 삭제
        public void remove(int index) {

            // index의 유효범위를 확인
            if(index < 0 || index >= size) {
                System.out.println("인덱스가 유효하지 않습니다.");
                return;
            }

            // 0 인덱스 노드 삭제
            if(index == 0) {
                removeFirst();
                return;
            }

            // 마지막 노드 삭제
            if(index == size - 1) {
                removeLast();
                return;
            }

            // 특정 index의 노드 삭제

            Node current = head;
            // index 번째 기존 노드를 찾기 위해 순회
            for(int i = 0; i < index; i++) {
                current = current.next;
            }

            // 기존 노드의 이전 노드의 next 포인터를 기존 노드의 next 노드로 설정
            current.prev.next = current.next;
            // 기존 노드의 다음 노드의 prev 포인터를 기존 노드의 prev 노드로 설정
            current.next.prev = current.prev;

            size--; // 리스트 사이즈 - 1

        }

        // 리스트 출력
        public void printList() {
            StringBuffer sb = new StringBuffer();
            sb.append("[");

            // head 노드부터 시작
            Node current = head;
            // 리스트 끝날때까지 순회
            while(current != null) {
                sb.append(current.data); // 현재 노드 data 출력
                // 다음 노드 있으면 구분자 출력
                if(current.next != null) sb.append(", ");
                // 다음 노드로 넘어감
                current = current.next;
            }

            sb.append("]");
            System.out.println(sb.toString());
        }

    }

    public static void main(String[] args) {

        DoubleLinkedList list = new DoubleLinkedList();

        list.add(10); // 처음 노드는 head이자 tail
        list.add(20);
        list.add(30);
        list.printList(); // [10, 20, 30]

        list.addFirst(5);
        list.printList(); // [5, 10, 20, 30]

        list.add(2, 15);
        list.printList(); // [5, 10, 15, 20, 30]

        list.removeLast();
        list.printList(); // [5, 10, 15, 20]

        list.removeFirst();
        list.printList(); // [10, 15, 20]

        list.remove(1);
        list.printList(); // [10, 20]

    }

}
