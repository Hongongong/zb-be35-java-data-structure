package tree;

class Node {

    int value; // 노드의 값
    Node left; // 왼쪽 자식 노드
    Node right; // 오른쪽 자식 노드

    public Node(int value) {
        this.value = value;
        // 노드 생성 시 자식 노드 없는 상태
        this.left = null;
        this.right = null;
    }
}

public class NodeBinaryTreeMain {

    public static void main(String[] args) {

        // 노드 한개씩 연결해서 이진 트리 생성

        // 최상단 노드(루트) 생성
        Node root = new Node(5);

        // root 노드의 자식 노드 연결
        root.left = new Node(4); // 루트의 왼쪽 자식 노드
        root.right = new Node(10); // 루트의 오른쪽 자식 노드

        // 2 레벨 노드의 자식 노드 연결
        root.left.left = new Node(15);
        root.left.right = new Node(1);

        root.right.left = new Node(20);
        root.right.right = new Node(8);

        // 3 레벨 노드의 자식 노드 연결
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(9);

        root.right.right.right = new Node(12);

        System.out.println("root 노드 : " + root.value); // 5
        System.out.println("root 왼쪽 자식 노드 : " + root.left.value); // 4
        System.out.println("root 오른쪽 자식 노드 : " + root.right.value); // 10
        System.out.println("4 노드의 오른쪽 자식 노드 : " + root.left.right.value); // 10
        System.out.println("1 노드의 왼쪽 자식 노드 : " + root.left.right.right.value); // 9

    }

}
