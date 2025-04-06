package array.practice;

/*
* 10개의 입력을 받아 총합과 최소값을 출력하세요.
* */

import java.util.*;
import java.io.*;

public class SumAndMinOfTenInputs {

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int[] arr = new int[10]; // 배열 생성
            int sum = 0;
            int min = Integer.MAX_VALUE; // Integer의 최대값으로 min 변수 설정

            for(int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(br.readLine());

                sum += arr[i]; // 합 변수에 더하기

                // 최소값 구하기
                if(arr[i] < min) min = arr[i];
            }

            StringBuffer sb = new StringBuffer();

            sb.append(sum).append("\n").append(min);

            System.out.println(sb.toString());

        }

    }

}
