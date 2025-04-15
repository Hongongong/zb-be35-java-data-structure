package programmers.week7.prob2;

import java.util.*;

public class Solution {

    // 주어진 상태 배열(status)을 모두 1로 만들기 위한 최소 스위치 클릭 횟수를 반환
    public static int solution(int[] status) {

        int length = status.length; // 배열 길이
        int count = 0; // 누른 스위치 개수 누적

        // 배열이 1개만 있을 때 예외 처리
        if(length == 1) {
            if(status[0] == 0) {
                return 1; // 하나만 0이면 한 번 눌러야 1이 됨
            } else {
                return 0; // 이미 1이므로 누를 필요 없음
            }
        }

        // 배열을 왼쪽에서 오른쪽으로 순회하면서 그리디하게 처리
        for(int i = 0; i < length - 1; i++) {

            // 현재 위치가 0이면 → 반드시 현재 위치에서 스위치 눌러야 함
            if(status[i] == 0) {

                if(i == length - 2) {
                    // 끝에서 두 번째 칸이면, i와 i+1만 반전 가능
                    status[i] = 1;
                    status[i+1] = 1 - status[i+1];

                } else {
                    // 그 외에는 i, i+1, i+2 모두 반전
                    status[i] = 1;
                    status[i+1] = 1 - status[i+1];
                    status[i+2] = 1 - status[i+2];

                }

                count++; // 버튼 클릭 수 증가

            }

        }

        // 최종 상태가 모두 1인지 확인
        for(int n : status) {
            if(n == 0) return -1; // 하나라도 0이 남으면 실패
        }

        return count; // 성공 시 최소 클릭 수 반환

    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 0, 1, 0, 1};

        System.out.println(solution(arr));

    }

}
