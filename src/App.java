import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static int countLetters(String input) {
        Set<String> latinSet = new HashSet<>(
                Arrays.asList("aw", "aa", "dd", "ee", "oo", "ow"));

        int count = 0;
        int index = 0;

        while (index < input.length()) {
            if (index < input.length() - 1) {
                String pair = input.substring(index, index + 2);

                if (latinSet.contains(pair)) {
                    count++;
                    index += 2;
                    continue;
                }
            }

            if (input.charAt(index) == 'w') {
                count++;
            }

            index++;
        }

        return count;
    }

    public static boolean isValid(String input) {
        for (int index = 0; index < input.length(); index++) {
            char character = input.charAt(index);

            if (!Character.isLetter(character)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Input: ");
            input = scanner.nextLine();

            if (isValid(input)) {
                break;
            }

            System.out.println("Input khong duoc chua ky tu dac biet hoac khoang trang.");
        }

        System.out.println("Output: " + countLetters(input));

        scanner.close();
    }
}
