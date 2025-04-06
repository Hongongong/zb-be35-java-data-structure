package array.practice;

import java.io.*;
import java.util.*;

public class ArrayResizeExample {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 기준점 : 어떨때, 데이터를 (배열을) 확장해야할까?
        // 즉, 배열의 index의 위치가 초과되었을때를 확인해 확장한다.

        int[] arr = new int[1];
        int index = 0;

        while(true) {

            int value = Integer.parseInt(br.readLine()); // 사용자 입력 받음

            // index가 범위를 막 초과한 경우 => 배열 1칸씩 확장
            if(index == arr.length) {

                // 메소드로 만들어 호출하는 경우
                arr = expendArr(arr); // 배열 확장

                // Arrays 활용하는 경우
                arr = Arrays.copyOf(arr, arr.length + 1);
            }
            arr[index] = value; // 배열에 데이터 추가
            index++; // 인덱스 + 1
            System.out.println(Arrays.toString(arr)); // 배열 출력

        }

    }

    public static int[] expendArr(int[] originalArr) {

        // index가 범위를 막 초과한 경우 => 배열 1칸씩 확장
        int[] newArr = new int[originalArr.length + 1];
        for(int i = 0; i < originalArr.length; i++) {
            newArr[i] = originalArr[i];
        }

        return newArr;

    }

}
