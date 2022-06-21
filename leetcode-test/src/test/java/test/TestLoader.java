package test;

/**
 * @author liaoshiqing
 * @date 2022/2/22 16:59
 */
public class TestLoader {
    static {
        System.out.println("static");
    }

    public static class Inner {
        public static final int VAL;
        static {
            VAL = 233;
            System.out.println("inner static");
        }
    }

    enum A {
        A;

        static {
            System.out.println("enum static");
        }

        A() {
            System.out.println("enum struct");
        }
    }

    public TestLoader() {
        System.out.println("struct");
    }

    public static void main(String[] args) {
        System.out.println("start");
        System.out.println(Inner.VAL);
        System.out.println(A.A);
        System.out.println("end");
    }
}
