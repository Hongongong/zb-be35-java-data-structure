package array;

import java.util.*;
import java.util.stream.*;

public class Array {
    public static void main(String[] args) {

        // 1. 기본적인 초기화
        int[] arr = new int[5]; // 사이즈를 명확하게 지정, 초기화는 안함
        System.out.println(Arrays.toString(arr)); // [0, 0, 0, 0, 0]

        // 2. 선언과 초기값 설정을 바로 하기
        int[] arr2 = {10, 30, 20}; // 사이즈 3짜리 배열 생성됨
        System.out.println(Arrays.toString(arr2)); // [10, 30, 20]

        // 3. 반복문을 사용한 초기화
        int[]arr3 = new int[5]; // 사이즈 5짜리 배열 생성, 초기화 아직 안됨

        Random rand = new Random();
        // 배열 순회
        for(int index = 0; index < arr3.length; index++) {
            arr3[index] = rand.nextInt(10); // 랜덤값으로 배열 초기화
        }

        System.out.println(Arrays.toString(arr3)); // [6, 9, 9, 7, 7] - 랜덤값으로 초기화되있음

        // 4. 배열을 특정한 값으로 일괄 초기화하기
        int[] arr4 = new int[5];
        Arrays.fill(arr4, 10); // 배열 값 10으로 전부 초기화

        System.out.println(Arrays.toString(arr4)); // [10, 10, 10, 10, 10]

        // 5. 스트림(Stream)을 활용한 초기화
        int[] arr5 = IntStream.range(0, 5).toArray(); // // 0 이상 5 미만의 int 값(0~4)을 갖는 스트림을 배열로 변환
        System.out.println(Arrays.toString(arr5)); // [0, 1, 2, 3, 4]

    }
}