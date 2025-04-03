package stack.practice;

import java.io.*;
import java.util.*;

/*
* 사용자한테 문장을 입력받고, 스택을 활용해 문장의 순서를 뒤집는 프로그램
* */

public class ReverseString {

    public static void main(String[] args) throws IOException {

        // 사용자한테 문자열 입력 받음 (자동 close되게 try-with-resources 구문 사용)
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String inputData = br.readLine();
            Stack<Character> stack = new Stack<>();

            // String -> Char 배열로 변환
            for(char ch : inputData.toCharArray()) {
                stack.push(ch); // stack에 char 단위로 삽입
            }

            StringBuffer sb = new StringBuffer();
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            System.out.println(sb.toString());

        }

    }

}
