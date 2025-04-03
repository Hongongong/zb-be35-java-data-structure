package stack;

public class StackOverflowExample {

    public static void main(String[] args) {

        int count = 1;
        A(count);

    }

    private static void A(int count) {

        System.out.println("call A = count " + count);
        A(count + 1);

    }

}
