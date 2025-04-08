package list;

/*
* 연속적으로 저장할 숫자를 첫 줄에 입력받고, 다음주에 숫자 2개를 입력받습니다.
* 숫자는 순서대로 넣고자하는 인덱스와 값입니다. 결과는 전체 리스트를 출력하세요.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class LinkedListInsertByIndex {

   public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String[] inputData = br.readLine().split(" ");
       List<Integer> list = new LinkedList<>();
       for(int i = 0; i < inputData.length; i++) {
           list.add(Integer.parseInt(inputData[i]));
       }

       inputData = br.readLine().split(" ");
       int index = Integer.parseInt(inputData[0]);
       int value = Integer.parseInt(inputData[1]);

       // 데이터 삽입
       list.add(index, value);

       // 삽입 후 리스트 출력
       System.out.println(list);

   }

}
