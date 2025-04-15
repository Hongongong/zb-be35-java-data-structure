package programmers.week5.prob3;

import java.util.*;

public class Solution {

    public static int[] solution(int[] a, int[] b) {

        // 배열의 마지막 인덱스부터 시작 (가장 낮은 자리수부터 더하기 위해)
        int i = a.length - 1;
        int j = b.length - 1;
        int carry = 0; // 덧셈 시 자릿수 올림 저장할 변수

        // 결과 값을 임시로 저장할 리스트 (뒤에서부터 추가 → 나중에 뒤집음)
        List<Integer> result = new ArrayList<>();

        // 두 배열이 끝날 때까지 또는 올림수가 남아있을 때까지 반복
        while (i >= 0 || j >= 0 || carry > 0) {

            // a의 현재 자리 숫자 (없으면 0)
            int digitA = (i >= 0) ? a[i--] : 0;

            // b의 현재 자리 숫자 (없으면 0)
            int digitB = (j >= 0) ? b[j--] : 0;

            // 현재 자리수의 합 + 이전 자리에서 올라온 올림수
            int sum = digitA + digitB + carry;

            // 다음 자리수로 넘길 올림수 저장
            carry = sum / 10;

            // 현재 자리수의 결과값을 리스트에 추가 (뒤에서부터 쌓는 방식)
            result.add(sum % 10);  // 뒤에 추가
        }

        // 올바른 순서로 바꾸기 위해 뒤집음
        Collections.reverse(result);

        // List → int[] 변환
        int[] answer = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            answer[k] = result.get(k);
        }

        return answer;

    }

    public static void main(String[] args) {

        int[] a = {5, 2, 1, 4, 6};
        int[] b = {6, 1, 0, 4, 4};

        System.out.println(Arrays.toString(solution(a, b)));

    }

}
