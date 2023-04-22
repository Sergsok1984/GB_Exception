// 4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//    Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.util.Objects;
import java.util.Scanner;

public class Task4 {
    static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите строку: ");
        String input = iScanner.nextLine();

        if(Objects.equals(input, "")){
            throw new RuntimeException("Пустую строку вводить нельзя!");
        }
        System.out.println("Введенная вами строка: " + input);
    }
}


