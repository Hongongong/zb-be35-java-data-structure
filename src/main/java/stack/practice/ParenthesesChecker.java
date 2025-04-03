package stack.practice;

import java.io.*;
import java.util.*;

/*
* ()로 이루어진 문자열을 받습니다.
* ‘(’과 ‘)’이 붙어있다면 한 쌍이며, 입력받은 문자열이 온전한 쌍으로만 이루어져있으면 True를 아니면 False를 출력.
* */

public class ParenthesesChecker {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String inputData = br.readLine();
            Stack<Character> stack = new Stack<>();

            // String -> Char 배열로 변환
            for (char ch : inputData.toCharArray()) {
                // 닫는 괄호일 때
                if (ch == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop(); // 짝이 맞으면 pop하고 다음 문자로 넘어감
                    } else {
                        stack.push(ch); // 짝이 안 맞으면 push
                    }
                } else { // 여는 괄호일때
                    stack.push(ch); // 무조건 push
                }
            }


            System.out.println(stack);
            System.out.println(stack.isEmpty());



        }

    }

}
