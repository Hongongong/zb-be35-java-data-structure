package array.practice;

/*
* 사용자에게 데이터의 크기를 입력받고, 값을 0~10 내로 랜덤하게 초기화하세요.
* 마지막엔 특정숫자를 입력받아, 해당 숫자의 개수를 출력하세요.
* */

import java.util.*;
import java.io.*;

public class CountTargetInRandomArray {

    public static void main(String[] args) throws IOException{

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int arrSize = Integer.parseInt(br.readLine()); // 배열의 크기
            int target = Integer.parseInt(br.readLine()); // 찾고자하는 숫자

            int[] arr = new int[arrSize]; // 배열 생성
            int count = 0; // tartget 숫자 개수

            Random random = new Random(); // 랜덤 객체 생성
            for(int i = 0; i < arrSize; i++) {
                arr[i] = random.nextInt(11);// 0 ~ 10 사이 랜덤한 수 생성해서 배열에 저장
                if(arr[i] == target) {
                    count++;
                }
            }

            // 배열 확인
            System.out.println(Arrays.toString(arr));

            System.out.println(count); // target 개수 출력

        }

    }

}
