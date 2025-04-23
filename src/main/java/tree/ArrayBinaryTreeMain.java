package tree;

// 배열을 이용한 이진 트리 구성, 순회

class BinaryTree {

    char[] arr;

    BinaryTree(char[] data) {
        this.arr = data.clone();
    }

    // 전위 순회
    public void preOrder(int idx) {

        // 1. 현재 노드 먼저 출력
        System.out.print(this.arr[idx] + " ");

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        // 2. 재귀를 통해 왼쪽 노드들 먼저 출력
        if(left < this.arr.length) {
            this.preOrder(left);
        }
        // 3. 오른쪽 노드들 출력
        if(right < this.arr.length) {
            this.preOrder(right);
        }
    }

    // 중위 순회
    public void inOrder(int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        // 1. 왼쪽 노드들 먼저 출력
        if(left < this.arr.length) {
            this.inOrder(left);
        }

        // 2. 현재 노드 출력
        System.out.print(this.arr[idx] + " ");

        // 3. 오른쪽 노드들 출력
        if(right < this.arr.length) {
            this.inOrder(right);
        }
    }

    // 후위 순회
    public void postOrder(int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        // 1. 왼쪽 노드들 먼저 출력
        if(left < this.arr.length) {
            this.inOrder(left);
        }

        // 2. 오른쪽 노드들 출력
        if(right < this.arr.length) {
            this.inOrder(right);
        }

        // 3. 현재 노드 출력
        System.out.print(this.arr[idx] + " ");
    }

    // 레벨 순회
    public void levelOrder(int idx) {
        for(int i = 0; i < this.arr.length; i++) {
            System.out.print(this.arr[idx] + " ");
        }
    }

}

public class ArrayBinaryTreeMain {

    public static void main(String[] args) {

        // Test code
        char[] arr = new char[10];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(0); // 0 idx 노드부터 전위 순회
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(0); // 0 idx 노드부터 중위 순회
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(0); // 0 idx 노드부터 후위 순회
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder(0); // 0 idx 노드부터 레벨 순회
        System.out.println();

    }

}
