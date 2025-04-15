package programmers.week5.prob1;

import java.util.Arrays;

public class Solution {

    public static int[] solution(int[] nums) {

        int n = nums.length;

        // 원소가 홀수개라면 짝을 이룰 수 없으므로 빈 배열 반환
        if (n % 2 != 0) return new int[0];

        // 오름차순 정렬
        // 작은 수부터 순차적으로 짝을 찾아야 신뢰성 있는 매칭 가능
        Arrays.sort(nums);

        // nums의 최댓값을 기준으로 2배까지 필요하므로 countArr 배열 길이 설정
        int max = nums[n - 1];
        int[] countArr = new int[max * 2 + 1];

        // 각 숫자의 등장 횟수를 countArr 배열에 저장
        for (int num : nums) {
            countArr[num]++;
        }

        // 최종 반환할 original 배열: 길이는 nums 절반
        int[] origianl = new int[n / 2];

        // origianl 배열 인덱스
        int idx = 0;

        // 다시 nums를 순회하며 original 구성
        for (int num : nums) {

            // 이미 짝으로 사용된 숫자는 건너뜀
            // 사용 가능 횟수가 0이면 더 이상 처리할 필요 없음
            if (countArr[num] == 0) continue;

            // num의 두 배 값이 countArr에 존재하지 않으면 → 짝이 안 맞는 케이스
            if (num * 2 >= countArr.length || countArr[num * 2] == 0) {
                return new int[0]; // 짝이 없음
            }

            // 짝이 존재하면 둘 다 사용 처리 (횟수 감소)
            countArr[num]--;
            countArr[num * 2]--;

            // original 배열에 원래 숫자(num)만 넣음
            origianl[idx++] = num;

        }

        return origianl;

    }

    public static void main(String[] args) {

        int[] arr = {1, 8, 2, 4, 5, 10};

        System.out.println(Arrays.toString(solution(arr)));

    }

}
