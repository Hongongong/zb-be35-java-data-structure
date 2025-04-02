package list;

import java.util.*;

public class ArrayList {

    public static class CustomArrayList {

        private int defaultSize = 10; // 기본 배열 사이즈
        private int[] data; // CustomArrayList
        private int size = 0; // ArrayList 끝 위치

        // 기본 생성자
        public CustomArrayList() {
            data = new int[defaultSize];
        }

        // ArrayList 크기 입력받을때 생성자
        public CustomArrayList(int size) {
            data = new int[size];
        }

        // 마지막에 데이터 삽입
        public void add(int value) {

            resizeDataSize(); // 배열 다 찼는지 확인

            data[size] = value; // 배열 끝에 데이터 추가
            size++; // 배열 끝 인덱스 변경

        }

        // 원하는 위치에 데이터 삽입
        public void add(int index, int value) {

            // 인덱스 범위 체크
            if(index < 0 || index > size) {
                System.out.println("인덱스 범위 초과");
                return;
            }

            resizeDataSize(); // 배열 다 찼는지 확인

            for(int i = size; i > index; i--) {
                data[i] = data[i - 1]; // 삽입 하려는 위치 다음 데이터들 뒤로 한칸씩 미루기
            }

            data[index] = value; // 데이터 삽입
            size++; // ArrayList 끝 index 늘림
        }

        // 마지막 데이터 삭제
        public void remove() {
            size--; // data 실제 삭제 안하고 index만 줄여도 한칸 삭제된거나 마찬가지
        }

        // 원하는 위치 데이터 삭제
        public void remove(int index) {

            // 인덱스 범위 체크
            if(index < 0 || index > size) {
                System.out.println("인덱스 범위 초과");
                return;
            }

            for(int i = index; i < size; i++) {
                data[i] = data[i + 1]; // 삭제하려는 데이터 뒤 데이터들을 앞으로 한칸씩 옮김
            }

            size--; // ArrayList 끝 index 줄임

        }

        // 데이터 가져오기
        public int get(int index) {

            // 인덱스 범위 체크
            if(index < 0 || index > size) {
                System.out.println("인덱스 범위 초과");
                return -1;
            }

            return data[index];

        }

        // ArrayList 전체 출력
        public void print() {
            StringBuffer sb = new StringBuffer();
            sb.append("[");

            // ArrayList 데이터 있는 만큼만 출력
            for(int i = 0; i < size; i++) {
                sb.append(data[i]);
                if(i < size - 1) sb.append(", ");
            }

            sb.append("]");

            System.out.println(sb.toString()); // sb 출력
        }

        public void realPrint() {
            System.out.println(Arrays.toString(data));
        }

        // ArrayList 사이즈 확인
        private void resizeDataSize() {

            // 배열 다 차지 않았다면
            if(data.length > size) return;

            // 배열 다 찼다면
            int newSize = data.length * 2; // 배열 사이즈 2배로 늘림
            int[] newArr = new int[newSize]; // 2배 사이즈 배열 생성

            for(int i = 0; i < data.length; i++) {
                newArr[i] = data[i]; // 기존 배열에 있던 값 옮기기
            }

            data = newArr; // CustomArrayList 새로 만든 배열로 변경

        }

    }


    public static void main(String[] args) {

        CustomArrayList list1 = new CustomArrayList();
        list1.print(); // []

        list1.add(10);
        list1.print(); // [10]

        list1.add(5);
        list1.print(); // [10, 5]

        list1.remove();
        list1.print(); // [10]

        list1.realPrint(); // [10, 5, 0, 0, 0, 0, 0, 0, 0, 0]

        list1.add(0, 3);
        list1.print(); // [3, 10]

        list1.realPrint(); // [3, 10, 0, 0, 0, 0, 0, 0, 0, 0]

        list1.add(-1, 7); // -1 인덱스 불가, ArrayIndexOutOfBoundsException 예외 발생
        // 인덱스 범위 초과
        list1.print(); // [3, 10]

        list1.remove(0);
        list1.print(); // [10]

        System.out.println(list1.get(0)); // 10

    }

}
