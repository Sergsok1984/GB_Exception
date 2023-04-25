import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static final String dataPath = "C:\\temp\\";
    public static Scanner in;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
        in = new Scanner(System.in);
        String inputData = "";
        boolean isValidData = false;

        try {
            inputData = dataInput();
            if (!inputData.isEmpty()) {
                System.out.println("Введённые данные: " + inputData);
                isValidData = true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if (isValidData) {
            try {
                System.out.println("ФИО: " + parseFIO(inputData));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (isValidData) {
            try {
                System.out.println("Дата рождения: " + parseBirthDate(inputData).format(formatter));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (isValidData) {
            try {
                System.out.println("Номер телефона: " + parsePhone(inputData));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (isValidData) {
            try {
                System.out.println("Пол: " + parseGender(inputData));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (isValidData) {
            try {
                saveToFile(inputData);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

    public static String dataInput() throws Exception {
        String result;
        System.out.println("Введите следующие данные через пробел: Фамилия Имя Отчество, дата рождения, номер телефона, пол (m или f)");
        result = in.nextLine();
        if (result.isEmpty()) {
            return "";
        } else if (result.split(" ").length < 6) {
            throw new Exception("Вы ввели меньше данных, чем требуется");
        } else if (result.split(" ").length > 6) {
            throw new Exception("Вы ввели больше данных, чем требуется");
        } else {
            return result;
        }
    }

    public static String parseGender(String inputData) throws Exception {
        String gender = "";
        String[] arr = inputData.split(" ");

        for (String s : arr) {
            if (s.equals("f") || s.equals("m")) {
                gender = s;
                break;
            }
        }

        if (gender.isEmpty()) {
            throw new Exception("Вы не ввели пол человека");
        }

        return gender;
    }

    public static long parsePhone(String inputData) throws Exception {
        long phone = 0;
        String[] arr = inputData.split(" ");

        for (String s : arr) {
            try {
                phone = Long.parseLong(s);
                break;
            } catch (Exception e) {
                phone = 0;
            }
        }

        if (phone == 0) {
            throw new Exception("Вы не ввели телефон");
        }

        return phone;
    }

    public static LocalDate parseBirthDate(String inputData) throws Exception {
        LocalDate dateTime = null;
        String[] arr = inputData.split(" ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        for (String s : arr) {
            try {
                dateTime = LocalDate.parse(s, formatter);
                break;
            } catch (Exception e) {
                dateTime = null;
            }
        }
        if (dateTime == null) {
            throw new Exception("Вы не ввели дату рождения");
        }

        return dateTime;

    }

    public static String parseFIO(String inputData) throws Exception {
        String fio = "";
        String[] arr = inputData.split(" ");

        for (int i = 0; i <= 3; i++) {
            if (!arr[i].equals("f") && !arr[i].equals("m") && !isContainsDigit(arr[i])) {
                fio = arr[i] + " " + arr[i + 1] + " " + arr[i + 2];
                break;
            }
        }

        if (fio.isEmpty()) {
            throw new Exception("Вы не ввели ФИО");
        }

        return fio;
    }

    public static boolean isContainsDigit(String str) {
        return str.matches(".*\\d.*");
    }

    public static String makeString(String inputData) throws Exception {

        return "<" + parseFIO(inputData).split(" ")[0] + ">" +
                "<" + parseFIO(inputData).split(" ")[1] + ">" +
                "<" + parseFIO(inputData).split(" ")[2] + ">" +
                "<" + parseBirthDate(inputData).format(formatter) + ">" +
                "<" + parsePhone(inputData) + ">" +
                "<" + parseGender(inputData) + ">";
    }

    public static String getFirstName(String inputData) {
        try {
            return parseFIO(inputData).split(" ")[0];
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    private static void saveToFile(String inputData) throws Exception {
        String filePath = dataPath + getFirstName(inputData) + ".txt";
        if (!checkFileName(filePath)) {
            File file = new File(filePath);
            file.createNewFile();

            try (FileWriter fw = new FileWriter(file, StandardCharsets.UTF_8)) {
                fw.write(makeString(inputData) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new Exception("Ошибка при попытке сохранить данные...");
            }
        } else {
            File file = new File(filePath);
            try (FileWriter fw = new FileWriter(file, StandardCharsets.UTF_8, true)) {
                fw.append(makeString(inputData)).append("\n");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new Exception("Ошибка при попытке сохранить данные...");
            }
        }
    }

    private static boolean checkFileName(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
}
