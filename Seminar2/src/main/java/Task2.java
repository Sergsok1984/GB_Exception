// 2. Если необходимо, исправьте данный код
//    try {
//        int d = 0;
//        double catchedRes1 = intArray[8] / d;
//        System.out.println("catchedRes1 = " + catchedRes1);
//    } catch (ArithmeticException e) {
//        System.out.println("Catching exception: " + e);
//    }

public class Task2 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        try {
            int d = 0;
            int item = 8;
            System.out.println("catchedRes1 = " + catchedRes1(array, d, item));
        } catch (NullPointerException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Проверьте индекс элемента массива: " + e);
        } catch (Exception e) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static double catchedRes1(int[] intArray, int d, int element) {
        double catchedRes1 = intArray[element] / d;
        return catchedRes1;
    }
}