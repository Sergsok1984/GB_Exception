// 2. Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?

//    public static int sum2d(String[][] arr) {
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < 5; j++) {
//                int val = Integer.parseInt(arr[i][j]);
//                sum += val;
//            }
//        }
//        return sum;
//    }

// Возможные исключения:
// 1. NullPointerException - если исходный массив null;
// 2. NumberFormatException - если строки в массиве содержат символы;
// 3. ArrayIndexOutOfBoundsException - если исходный массив имеет длину меньше, чем задана в условии метода.
