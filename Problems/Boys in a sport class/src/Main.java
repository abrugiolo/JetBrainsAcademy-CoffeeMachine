import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h1 = scanner.nextInt();
        int h2 = scanner.nextInt();
        int h3 = scanner.nextInt();

        // 165 161 158 = true
        // 155 165 160 = false
        // 161 161 165 = true

        boolean result = false;

        if (((h1 <= h2) && (h2 <= h3)) || ((h1 >= h2) && (h2 >= h3))) {
            result = true;
        }

        System.out.print(result);
    }
}