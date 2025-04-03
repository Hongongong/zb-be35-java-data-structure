package stack.practice;

/*
* 중위 표현식을 후위 표현식으로 변환하는 코드 (연산자 우선순위 있음)
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixToPostfixConverter2 {

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringBuilder sb = new StringBuilder();

            String inputData = br.readLine();
            Stack<Character> stack = new Stack<>();

            // string -> char 배열로 변환해서 순회
            for(char ch : inputData.toCharArray()) {

                // 연산자 라면
                if(ch == '+' || ch == '-' || ch == '/' || ch == '*') {

                    // 스택이 비어있지 않고, 현재 연산자보다 stack의 top 요소 연산자가 우선순위가 높을때
                    while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                        sb.append(stack.pop()); // top 요소 pop해서 sb에 저장
                    }

                    // 우선순위 높은 연산자 다 pop-출력 하고
                    stack.push(ch); // 새 연산자 push

                } else if('0' <= ch && ch <= '9'){ // 숫자라면

                   sb.append(ch); // 바로 sb에 저장

                }

            }

            // 남은 연산자 pop
            while(!stack.isEmpty()) { // 스택 비어있지않을때
                sb.append(stack.pop()); // top 요소 pop해서 sb에 저장
            }

            System.out.println(sb.toString());

        }

    }

    // 연산자 우선순위 비교하는 메서드
    private static int precedence(char ch) {

        if(ch == '+' || ch == '-') return 0;
        if(ch == '*' || ch == '/') return 1;

        return -1;

    }

}
