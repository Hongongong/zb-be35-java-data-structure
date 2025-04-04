package stack.practice;

/*
* 스택 2개를 이용해서, 오름차순 정렬을 해보세요.
* */

import java.util.*;
import java.io.*;

public class StackSort {

    // 스택 내림차순 정렬
    public static void sortStack(Stack<Integer> originalStack) {

        Stack<Integer> sortedStack = new Stack<>();

        // 기본스택 빌 때까지
        while(!originalStack.isEmpty()) {
            int now = originalStack.pop(); // 기본스택 top 요소 빼냄

            // 정렬스택이 비지않고 정렬스택의 top 요소가 now 요소보다 클동안
            while(!sortedStack.isEmpty() && sortedStack.peek() > now) {

                // 정렬스택의 top 요소 pop 해서 기본스택에 삽입
                originalStack.push(sortedStack.pop());

            }

            sortedStack.push(now); // 정렬스택에 now 요소 삽입
        }

        // 1~6 정렬되어있는 스택 뒤짚기(최종 오름차순으로 빼내기 위해)
        // 정렬스택이 빌 때까지
        while(!sortedStack.isEmpty()) {
            // 정렬스택 값들 빼서 기본스택에 삽입
            originalStack.push(sortedStack.pop());
        }

    }

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] inputData = br.readLine().split(" ");

            Stack<Integer> stack = new Stack<>();
            for(String data : inputData) {

                stack.push(Integer.parseInt(data));

            }

            // 내림차순 정렬 (stack 출력시 오름차순으로 값 나옴)
            sortStack(stack);

            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }

            System.out.println(sb.toString());

        }

    }

}
