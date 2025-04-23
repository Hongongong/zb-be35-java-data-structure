package tree;

import java.util.*;

public class ArrayListBinaryTreeMain {

    public static void main(String[] args) {

        ArrayList<Integer> tree = new ArrayList<>(Arrays.asList(

                // 노드 없는 인덱스에는 null 저장(노드 없음 표시)
                5, 4, 10, 15, 1, 20, 8, null, null, 3, 9, null, null, null, 12

        ));

        int target = 6;
        Integer left = target * 2 + 1; // null 값도 같이 저장하기 위해 Integer로 저장
        Integer right = target * 2 + 2; // null 값도 같이 저장하기 위해 Integer로 저장

        System.out.println(tree.get(target)); // 4 (1 인덱스의 노드의 값)
        System.out.println(tree.get(left)); // 15 (1 인덱스 노드의 왼쪽 자식의 값)
        System.out.println(tree.get(right)); // 1 ( 1 인덱스 노드의 오른쪽 자식의 값)
    }

}
