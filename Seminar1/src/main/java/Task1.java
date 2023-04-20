// 1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(method1(5, 0));
        System.out.println(method2(null));
        System.out.println(Arrays.toString(method3(10, 20, 2)));
    }
    public static int method1(int a, int b) {
        return a / b;
        // ArithmeticException
    }

    public static int method2(String str) {
        return str.length();
        // NullPointerException
    }

    public static int[] method3(int a, int b, int c) {
        int[] array = new int[a];
        array[b] = c;
        return array;
        // ArrayIndexOutOfBoundsException
    }
}
