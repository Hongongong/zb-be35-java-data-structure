package stack;

public class StackMain {

    public static class Stack {

        private int[] stackArr; // 스택 배열
        private int top; // stack 의 최상위 원소 인덱스 값
        private int size; // 스택 사이즈 (데이터 들어있는 개수)

        // 생성자
        public Stack() {

            this.size = 0;
            this.stackArr = new int[10];
            top = -1;

        }

        // top에 데이터 삽입
        public void push(int value) {

            // stack 가득차있다면
            if(isFull()) {
                System.out.println("현재 스택이 가득찼습니다.");
                return;
            }

            this.stackArr[++top] = value; // top+1 인덱스에 값 삽입
            this.size++; // stack 사이즈 늘림

        }

        // top에 데이터 삭제
        public void pop() {

            // stack 비어있다면
            if(isEmpty()) {
                System.out.println("현재 스택이 비어있습니다.");
                return;
            }

            this.top--; // top 값 줄임(뒷 인덱스 값이 있지만 삭제한거나 마찬가지)
            this.size--; // stack 사이즈 줄임
        }

        // top 데이터 확인
        public int peek() {

            // stack 비어있다면
            if(isEmpty()) {
                System.out.println("현재 스택이 비어있습니다.");
                return -1;
            }

            return this.stackArr[top];
        }

        // stack 비었는지 확인
        public boolean isEmpty() {
            return top == -1; // -1 이면 true, 아니면 false
        }

        // stack 가득찼는지 확인
        public boolean isFull() {
            return top == stackArr.length - 1; // 같으면 가득 찬것
        }

        // 스택 배열 출력
        public void printStack () {
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i <= top; i++) {
                sb.append(stackArr[i]).append(" ");
            }
           System.out.println(sb.toString());
        }

    }

    public static void main(String[] args) {

        // 스택 생성
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack(); // 10 20 30

        stack.pop(); // 30 제거
        stack.printStack(); // 10 20

        System.out.println(stack.isEmpty()); // false

        stack.pop(); // 20 제거
        stack.pop(); // 10 제거
        stack.pop(); // 현재 스택이 비어있습니다.

        stack.push(5);
        System.out.println(stack.peek()); // 5

        for(int i = 1; i < 10; i++) {
            stack.push(i);
        }
        stack.printStack(); // 5 1 2 3 4 5 6 7 8 9
        System.out.println(stack.isFull()); // true
        stack.push(11); // 현재 스택이 가득찼습니다.
    }

}
