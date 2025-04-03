package stack.practice;

/*
* 중위 표현식을 후위 표현식으로 변환하는 코드 (연산자 우선순위 없음)
* */

import java.io.*;
import java.util.*;

public class InfixToPostfixConverter1 {

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringBuilder sb = new StringBuilder();

            String inputData = br.readLine();
            Stack<Character> stack = new Stack<>();

            // string -> char 배열로 변환해서 순회
            for(char ch : inputData.toCharArray()) {

                // 연산자 라면
                if(ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                    if(!stack.isEmpty()) { // 스택 비어있지않을때
                        sb.append(stack.pop()); // top 요소 pop해서 sb에 저장
                    }
                    stack.push(ch); // 새 연산자 push
                } else if('0' <= ch && ch <= '9'){ // 숫자라면
                   sb.append(ch); // 바로 sb에 저장
                }

            }

            // 마지막 연산자 pop
            if(!stack.isEmpty()) { // 스택 비어있지않을때
                sb.append(stack.pop()); // top 요소 pop해서 sb에 저장
            }

            System.out.println(sb.toString());

        }

    }

}
