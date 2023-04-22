// 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
//    и возвращает введенное значение.
//    Ввод текста вместо числа не должно приводить к падению приложения,
//    вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.Scanner;

public class Task1 {
    static Scanner iScanner = new Scanner(System.in);
    static String input;

    public static void main(String[] args) {
        System.out.println("Вы ввели число: " + inpFloat());
    }

    public static float inpFloat() {

        System.out.println("Введите дробное число используя точку: ");
        input = iScanner.next();

        while (!input.matches("[+-]?([0-9][.]?)+[0-9]+")) {
            System.out.println("Неверный ввод! Введите дробное число еще раз!");
            input = iScanner.nextLine();
        }
        iScanner.close();
        return Float.parseFloat(input);
    }
}
