package stack;

public class CallStack {

    public static void main(String[] args) {

        A();
        B();

    }

    private static void A() {

    }

    private static void B() {
        C();
    }

    private static void C() {

    }

}
