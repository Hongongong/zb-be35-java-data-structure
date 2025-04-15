package programmers.week5.prob2;

import java.util.*;

public class Solution {

    public static int solution(int[] numbers) {

        // 배열 오름차순 정렬
        Arrays.sort(numbers);

        // 비어있는 숫자 중 가장 작은 숫자 담을 변수
        int target = -1;
        for(int i = 1; i < numbers.length; i++) {

            // numbers 배열에서 i번째 수와 i-1번째 수의 차이가 2 이상이면 비어있는 수 1개 이상
            if(numbers[i] - numbers[i - 1] >= 2) {
                // 비어있는 수 중 가장 작은수만 target에 저장
                target = numbers[i - 1] + 1;
                // 비어있는 수 중 가장 작은수 찾았으므로 바로 종료
                break;
            }

        }

        return target;

    }

    public static void main(String[] args) {

        int[] arr = {9, 4, 2, 3, 7, 5};

        System.out.println(solution(arr));

    }

}
