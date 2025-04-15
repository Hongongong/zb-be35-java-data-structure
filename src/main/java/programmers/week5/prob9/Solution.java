package programmers.week5.prob9;

import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        String answer = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            char[] code = br.readLine().toCharArray();

            Stack<Character> stack = new Stack<Character>();
            for(int i = 0; i < code.length; i++) {

                char ch = code[i];

                if(ch == '}') {

                    // 문자 임시 저장할 sb
                    StringBuilder tempSb = new StringBuilder();

                    // 중괄호 안의 문자열을 꺼내기
                    while (true) {
                        char top = stack.pop();
                        // 여는 괄호 만나면 종료
                        if (top == '{') {
                            break;
                        }
                        tempSb.insert(0, top); // 문자열 앞에 top 붙이기 (순서 유지)
                    }

                    // 반복 횟수 만나면 문자 반복해서 sb에 삽입
                    if (stack.peek() >= '1' && stack.peek() <= '9') {
                        int repeat = stack.pop() - '0';
                        String repeatStr = tempSb.toString().repeat(repeat);

                        for (char c : repeatStr.toCharArray()) {
                            stack.push(c);
                        }
                    }

                } else {

                    stack.push(ch);

                }

            }

            // 결과 문자열 만들기
            StringBuilder result = new StringBuilder();
            for (char c : stack) {
                result.append(c);
            }

            answer = result.toString();

        }


        System.out.println(answer);

    }

}
