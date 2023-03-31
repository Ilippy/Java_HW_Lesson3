import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

class Homework {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        removeEvenNumber(numbers);
        System.out.println(numbers);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("string");
        strings.add("40");
        strings.add("-5");
        strings.add("my_string");
        removeIntegers(strings);
        System.out.println(strings); // [string, my_string]
    }

    static void removeEvenNumber(List<Integer> numbers) {
        // TODO: 31.03.2023 Удалить все четные элементы из списка
        // 1 решение
        numbers.removeIf(s -> s % 2 == 0);

        // 2 решение
        // for (int i = 0; i < numbers.size(); i++) {
        //     if (numbers.get(i) % 2 == 0) {
        //         numbers.remove(i);
        //         i--;
        //     }
        // }

        // 3 решение
        // Iterator<Integer> it = numbers.iterator();
        // while (it.hasNext()) {
        //     if (it.next() % 2 == 0) {
        //         it.remove();
        //     }
        // }
    }

    static void removeIntegers(List<String> strings) {
        // TODO: 31.03.2023 Удалить строки, которые являются целыми числами
        // 1 решение
        strings.removeIf(s -> isNumeric1(s));
        // 2 решение
        // strings.removeIf(s -> isNumeric2(s));
        // 3 решение
        // strings.removeIf(s -> isNumeric3(s));

    }

    static boolean isNumeric1(String str) {
        if (str == null) {
            return false;
        }
        try {
            int n = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    static boolean isNumeric2(String str) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (str == null) {
            return false;
        }
        return pattern.matcher(str).matches();
    }

    static boolean isNumeric3(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isDigit(charArray[i])) {
                if (i == 0 && charArray[i] == '-' && charArray.length > 1) {
                    continue;
                }
                return false;

            }
        }
        return true;
    }

}