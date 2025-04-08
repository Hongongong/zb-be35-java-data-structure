package array;

/*
* 연속적으로 저장할 숫자를 첫 줄에 입력받고, 다음주에 숫자 2개를 입력받습니다.
* 숫자는 순서대로 넣고자하는 인덱스와 값입니다. 결과는 전체 리스트를 출력하세요.
* */

import java.io.*;
import java.util.*;

public class ListInsertByIndex {

   public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String[] inputData = br.readLine().split(" ");
       int[] arr = new int[inputData.length];
       for(int i = 0; i < inputData.length; i++) {
           arr[i] = Integer.parseInt(inputData[i]);
       }

       inputData = br.readLine().split(" ");
       int index = Integer.parseInt(inputData[0]);
       int value = Integer.parseInt(inputData[1]);

       // 원래 배열 다 찼으므로 크기 늘린 새 배열 생성
       int[] newArr = new int[arr.length + 1];

       // 삽입할 위치 앞까지의 데이터 그대로 복붙
       for(int i = 0; i < index; i++) {
           newArr[i] = arr[i];
       }
       // 데이터 삽입
       newArr[index] = value;

       // 삽인한 위치 후의 데이터 복붙
       for(int i = index + 1; i < newArr.length; i++) {
           newArr[i] = arr[i - 1];
       }

       // 삽입 후 배열 출력
       System.out.println(Arrays.toString(newArr));

   }

}
