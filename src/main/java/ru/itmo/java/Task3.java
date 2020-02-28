package ru.itmo.java;

import java.util.HashSet;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            int a[] = new int[0];
            return a;
        }
        int res[] = new int[inputArray.length];
        res[0] = inputArray[inputArray.length - 1];
        for (int i = 1; i < res.length; i++) {
            res[i] = inputArray[i - 1];
        }
        return res;
//        throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        }
        if (inputArray.length == 1) {
            return inputArray[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; i < inputArray.length; i++) {
                if (i != j) {
                    int tmp = inputArray[i] * inputArray[j];
                    if (max < tmp) {
                        max = tmp;
                    }
                }
            }
        }
        return max;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        int cnt = 0;
        if (input == null || input.length() == 0) {
            return 0;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'A' || input.charAt(i) == 'b' || input.charAt(i) == 'B') {
                cnt++;
            }
        }
        return (100 * cnt / input.length());

    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        StringBuilder line = new StringBuilder(input);
        line.reverse();
        String a = line.toString();
        return a.equals(input);
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        char c = input.charAt(0);
        int cnt = 1;
        String res = "";
        for (int i = 1; i < input.length(); i++) {
            if (c == input.charAt(i)) {
                cnt++;
            } else {
                res += c;
                res += cnt;
                cnt = 1;
                c = input.charAt(i);
            }
        }
        res += c;
        res += cnt;
        return res;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        int size = 256;
        int arr1[] = new int[size];
        int arr2[] = new int[size];

        if (one == null || two == null || (one.length() == 0 && two.length() == 0) || one.length() != two.length()) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 0;
            arr2[i] = 0;
        }
        for (int i = 0; i < one.length(); i++) {
            arr1[one.charAt(i)]++;
            arr2[two.charAt(i)]++;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int size = 256;
        int arr1[] = new int[size];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i)]++;
            if (arr1[s.charAt(i)] > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null || m[0].length == 0) {
            return new int[][]{{}, {}};
        }
        int a[][] = new int[m.length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                a[j][i] = m[i][j];
            }
        }
        return a;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        String res = "";
        if (inputStrings == null) {
            return res;
        }
        if (separator == null) {
            separator = ' ';
        }

        for (int i = 0; i < inputStrings.length; i++) {
            res += inputStrings[i];
            if (i != inputStrings.length - 1) {
                res += separator;
            }
        }
        return res;
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        int cnt = 0;
        boolean flag = false;
        if (inputStrings == null || inputStrings.length == 0 || prefix == null) {
            return cnt;
        }
        for (int i = 0; i < inputStrings.length; i++) {
            if (prefix.length() > inputStrings[i].length()) {
                continue;
            }
            flag = false;
            for (int j = 0; j < prefix.length(); j++) {
                if (inputStrings[i].charAt(j) != prefix.charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                cnt++;
            }

        }
        return cnt;
    }
}
