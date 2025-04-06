package list.practice;

/*
* 전 문제에서 I의 형식을 바꿉니다. I 다음에는 값과 위치를 넣습니다.
* 위치가 입력되지 않거나 사이즈보다 큰 값이면, 가장 뒤에 값을 넣습니다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class SimpleListEditor2 {

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            List<Integer> list = new ArrayList<>(); // 리스트 생성

            String command = "0"; // 명령어 변수

            // 명령어가 'E'가 입력되면 종료
            while(!command.equals("E")) {

                String[] inputData = br.readLine().split(" "); // 사용자 입력 받아서 String 배열로 반환

                command = inputData[0]; // 입력된 명령어

                // 입력된 명령어따라 실행
                if(command.equals("I")) {
                    int value = Integer.parseInt(inputData[1]); // 입력된 값

                    // 위치 입력 안되면
                    if(inputData.length == 2) {
                        list.add(value); // 리스트의 끝에 값 추가
                    } else { // 위치 입력됐으면

                        int index = Integer.parseInt(inputData[2]); // 삽입할 위치

                        if(index < list.size()) {
                            list.add(index, value); // 리스트의 해당 위치에 값 추가
                        } else {
                            list.add(value); // 리스트 끝에 값 추가
                        }

                    }


                } else if(command.equals("D")) {

                    // list 비어있지 않을때
                    if(!list.isEmpty()) {
                        list.remove(list.size() - 1); // 리스트 마지막 값 삭제
                    }

                }

            }

            // 출력
            StringBuilder sb = new StringBuilder();

            // list 비어있을때
            if(list.isEmpty()) {
                sb.append(-1).append("\n").append(-1).append("\n").append(0); // 전부 -1 로 출력
            } else { // 비어있지 않을때

                sb.append(list.get(list.size() - 1)).append("\n"); // 마지막 값

                // StringJoiner - 각 요소 사이 구분자 넣을때 사용
                StringJoiner sj = new StringJoiner(" "); // 각 요소 사이 공백 추가됨
                for(int value : list) {
                    sj.add(Integer.toString(value)); // 현재 값을 문자열로 변환후 sj에 추가
                }
                sb.append(sj.toString()).append("\n"); // 공백으로 연결된 리스트 목록 sb에 추가

                sb.append(list.size()); // 리스트 사이즈

            }

            System.out.println(sb.toString()); // sb 출력

        }

    }

}
