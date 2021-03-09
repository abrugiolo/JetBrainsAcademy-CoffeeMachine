import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        boolean triangleExists = false;

        if ((a + b > c) && (a + c > b) && (b + c > a)) {
            triangleExists = true;
        }

        System.out.printf("%s", triangleExists ? "YES" : "NO");
    }
}