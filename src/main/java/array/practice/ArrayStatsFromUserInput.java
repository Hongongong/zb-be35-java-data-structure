package array.practice;

import java.util.*;
import java.io.*;

public class ArrayStatsFromUserInput {

    // 개행문자 상수로 사용
    public static final String ENTER = "\n";

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N]; // 배열 생성

            int sum = 0; // 합계 변수
            int min = Integer.MAX_VALUE; // 최소값 변수
            int max = Integer.MIN_VALUE; // 최대값 변수

            // 입력 받으면서 합, 최소, 최대 구하기
            for(int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(br.readLine());

                sum += arr[i]; // 합계 더하기

                if(arr[i] < min) min = arr[i]; // 최소값 구하기
                else if(arr[i] > max) max = arr[i]; // 최대값 구하기

            }

            StringBuilder sb = new StringBuilder();

            sb.append(sum).append(ENTER)
                    .append(String.format("%.2f", (double)sum / N)).append(ENTER)
                    .append(min).append(ENTER)
                    .append(max);

            System.out.println(sb.toString());

        }

    }

}
