package list.practice;

/*
* 사용자가 입력한 명령어에 따라 리스트에 값을 추가/삭제합니다.
* 명령어는 I(마지막에 입력; 양수만 가능), D(마지막 값 삭제), E(종료)로 진행되며,
* 결과는 종료 이후에 가장 마지막 값, 모든 값, 사이즈를 출력합니다. 비어있다면 -1를 출력합니다.
* 단, D는 I의 횟수보다 더 많이 입력될 수 없습니다.
* */

import java.io.*;
import java.util.*;

public class SimpleListEditor {

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
                    list.add(value); // 리스트에서 추가
                } else if(command.equals("D")) {
                    list.remove(list.size() - 1); // 리스트 마지막 값 삭제
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
